package leetCode.topInterView.easy.Strings.atoI;

import java.util.ArrayList;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.easy.Strings.atoI
 * @since : 2023/03/13
 */
public class StringtoIntegerSolution2 implements StringtoIntegerSolution {

  private char[] chars;
  private boolean isNegative = false;
  private ArrayList<Character> resultStr = new ArrayList<>();
  private int resultValue = 0;

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

  private void readLetters() {
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

  public boolean isNumber(char aChar) {
    return aChar > 47 && aChar < 58;
  }

  private void checkNegativeOrPositive() {
    if (chars[0] == '-') {
      isNegative = true;
    }
  }

  private void convertToCharArr(String s) {
    chars = s.trim().toCharArray();
  }
}
