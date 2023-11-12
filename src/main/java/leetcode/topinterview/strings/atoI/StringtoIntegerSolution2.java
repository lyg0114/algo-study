package leetcode.topinterview.strings.atoI;

import java.util.ArrayList;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Strings.atoI
 * @since : 2023/03/13
 */
public class StringtoIntegerSolution2 implements StringtoIntegerSolution {

  private char[] chars;
  private boolean isNegative = false;
  private final ArrayList<Character> resultStr = new ArrayList<>();
  private int resultValue = 0;
  private final int PREVIOUS_MAX_INTEGER = Integer.MAX_VALUE / 10;

  @Override
  public int myAtoi(String s) {
    convertToCharArr(s);
    checkNegativeOrPositive();
    readLetters();
    convertToInteger();
    return resultValue;
  }

  private void convertToInteger() {
    if (resultStr.size() == 0) {
      return;
    }
    if (!isNegative) {
      convertPositiveInteger();
    }
    if (isNegative) {
      convertNegativeInteger();
    }
  }

  private void convertPositiveInteger() {
    resultValue = convertCharToInt(resultStr.get(0));
    if (resultStr.size() > 1) {
      int index = 1;
      while (true) {
        resultValue = (resultValue * 10) + convertCharToInt(resultStr.get(index));
        if (++index == resultStr.size()) {
          break;
        }
        if (resultValue > PREVIOUS_MAX_INTEGER) {
          resultValue = Integer.MAX_VALUE;
          break;
        }
        if (resultValue == PREVIOUS_MAX_INTEGER) {
          if (resultStr.get(index) == '8' || resultStr.get(index) == '9'
              || resultStr.size() > 10) {
            resultValue = Integer.MAX_VALUE;
            break;
          }
        }
      }
    }
  }

  private void convertNegativeInteger() {
    if (resultStr.size() == 1) {
      resultValue = convertCharToInt(resultStr.get(0));
      resultValue *= -1;
      return;
    }
    if (resultStr.size() > 1) {
      resultValue = convertCharToInt(resultStr.get(0));
      int index = 1;
      while (true) {
        resultValue = (resultValue * 10) + convertCharToInt(resultStr.get(index));
        if (++index == resultStr.size()) {
          resultValue *= -1;
          break;
        }
        if (resultValue > PREVIOUS_MAX_INTEGER) {
          resultValue = Integer.MIN_VALUE;
          break;
        }
        if (resultValue == PREVIOUS_MAX_INTEGER) {
          if (resultStr.get(index) == '9' || resultStr.size() > 10) {
            resultValue = Integer.MIN_VALUE;
            break;
          }
        }
      }
    }
  }

  private int convertCharToInt(Character ch) {
    return ch - 48;
  }

  private void readLetters() {
    if (chars.length > 0) {
      int start = 0;
      if (chars[0] == '+' || chars[0] == '-') {
        start = 1;
      }
      for (int i = start; i < chars.length; i++) {
        if (!isNumber(chars[i])) {
          break;
        }
        resultStr.add(chars[i]);
      }
    }
  }

  public boolean isNumber(char aChar) {
    return aChar > 47 && aChar < 58;
  }

  private void checkNegativeOrPositive() {
    if (chars.length > 0) {
      if (chars[0] == '-') {
        isNegative = true;
      }
    }
  }

  private void convertToCharArr(String s) {
    chars = s.trim().toCharArray();
  }
}
