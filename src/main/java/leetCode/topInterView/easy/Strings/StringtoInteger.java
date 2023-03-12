package leetCode.topInterView.easy.Strings;

import java.util.ArrayList;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.easy.Strings
 * @since : 2023/03/09 https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/884/
 * 1. 공백제거 2. +,- 판별 3. 첫번째자리 확인 0이 첫번째에 올 수 없음 4. 자리수 확인
 */
public class StringtoInteger {

  public static void main(String[] args) {
    String str = "42";
    StringtoIntegerSolution solution = new StringtoIntegerSolution();
  }
}

class StringtoIntegerSolution {

  private boolean isNegative = false;
  private int indexOfFirstDigit = -1;
  char[] chars;
  private ArrayList<Character> resultStr = new ArrayList<>();
  private int resultValue;

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
    if(indexOfFirstDigit < 0)
      throw new NumberFormatException("emtpy string");

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
      for (int j = i; j < chars.length; j++) {
        chars[j] = ' ';
      }
    }
  }

  public void charValidation(char[] chars, int index) {
    if (index == 0) {
      checkNegative(chars[index]);
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

  public void checkNegative(char aChar) {
    if (aChar == '-') {
      isNegative = true;
    } else if (aChar == '+') {
      isNegative = false;
    } else {
      isNegative = false;
    }
  }

  public boolean isNegative() {
    return isNegative;
  }

  public int getIndexOfFirstDigit() {
    return indexOfFirstDigit;
  }
}
