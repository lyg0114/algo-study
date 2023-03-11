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

  public int myAtoi(String input) {
    try {
      validation(input);
      createFinalStr();
    } catch (NumberFormatException e) {
      return 0;
    }
    return 0;
  }

  private void createFinalStr() {
    for (int i = indexOfFirstDigit; i < chars.length; i++) {
      if (chars[i] != ' ') {
        resultStr.add(chars[i]);
      }
    }
  }

  private void validation(String input) {
    String trimInput = input.trim();
    chars = trimInput.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      charValidation(chars, i);
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
      if (!isNumber(chars[index])) {
        chars[index] = ' ';
      }
    }
  }

  public void checkFirstDigit(char aChar, int index) {
    if (indexOfFirstDigit == -1) {
      if (aChar > 48 && aChar < 58) {
        indexOfFirstDigit = index;
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

  public ArrayList<Character> getResultChars() {
    return resultStr;
  }
}
