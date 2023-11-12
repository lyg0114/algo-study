package leetcode.topinterview.strings.atoI;

import java.util.ArrayList;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Strings.atoI
 * @since : 2023/03/13
 */
public class StringtoIntegerSolution1 implements StringtoIntegerSolution {

  private boolean isNegative = false;
  private int indexOfFirstDigit = -1;
  char[] chars;
  private ArrayList<Character> resultStr = new ArrayList<>();
  private int resultValue;

  @Override
  public int myAtoi(String s) {
    try {
      validation(s);
      createFinalStr();
      result();
      return resultValue;
    } catch (NumberFormatException e) {
      System.out.println("e.getMessage() = " + e.getMessage());
      e.printStackTrace();
      return 0;
    }
  }

  private void result() {
    resultValue = convertCharToInt(resultStr.get(0));
    if (resultStr.size() > 1) {
      int index = 1;
      while (true) {
        resultValue = (resultValue * 10) + convertCharToInt(resultStr.get(index));
        if (++index == resultStr.size()) {
          break;
        }
        if (resultValue > Integer.MAX_VALUE / 10) {
          resultValue = Integer.MAX_VALUE;
          if (isNegative) {
            resultValue = Integer.MIN_VALUE;
          }
          break;
        }
      }
    }

    if (isNegative) {
      resultValue *= -1;
    }
  }

  private int convertCharToInt(Character ch) {
    return ch - 48;
  }

  private void createFinalStr() {
    if (indexOfFirstDigit < 0) {
      throw new NumberFormatException("emtpy string");
    }

    for (int i = indexOfFirstDigit; i < chars.length; i++) {
      if (chars[i] != ' ') {
        resultStr.add(chars[i]);
      }
    }
  }

  private void validation(String input) {
    String trimInput = input.trim();
    chars = trimInput.toCharArray();
    int i = 0;
    try {
      for (i = 0; i < chars.length; i++) {
        charValidation(chars, i);
      }
    } catch (RuntimeException e) {
      if (e.getMessage().equals("bf")) {
        throw new NumberFormatException("bf");
      }
      for (int j = i; j < chars.length; j++) {
        chars[j] = ' ';
      }
    }
  }

  public void charValidation(char[] chars, int index) {
    if (index == 0) {
      checkNegative(chars, index);
    }
    checkFirstDigit(chars[index], index);
    checkNumber(chars, index);
  }

  private void checkNumber(char[] chars, int index) {
    if (indexOfFirstDigit > -1) {
      if (chars[index] == '.') {
        throw new RuntimeException(". has occured");
      }
      if (!isNumber(chars[index])) {
        chars[index] = ' ';
        int before = index - 1;
        int after = index + 1;
        if (isNumber(chars[before]) && isNumber(chars[after])) {
          throw new NumberFormatException("bf");
        }
      }
    }
  }

  public void checkFirstDigit(char aChar, int index) {
    if (indexOfFirstDigit == -1) {
      if (aChar > 48 && aChar < 58) {
        indexOfFirstDigit = index;
      } else {
        if ((aChar == '+' || aChar == '-') || isNumber(aChar)) {
          return;
        }
        throw new NumberFormatException(aChar + "is not number");
      }
    }
  }

  public boolean isNumber(char aChar) {
    return aChar > 47 && aChar < 58;
  }

  public void checkNegative(char[] chars, int index) {
    if (chars[index] == '-' || chars[index] == '+') {
      int next = index + 1;
      if (chars[next] == '-' || chars[next] == '+') {
        throw new NumberFormatException("wrong str");
      }
    }

    if (chars[index] == '-') {
      isNegative = true;
    } else if (chars[index] == '+') {
      isNegative = false;
    } else {
      isNegative = false;
    }
  }

}
