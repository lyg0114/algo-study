package leetCode.topInterView.easy.Strings;

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

  public int myAtoi(String input) {
    String trim = input.trim();
    char[] chars = trim.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (i == 0) {
        checkNegative(chars[i]);
      }
      if (!checkValidation(chars[i])) {
        return 0;
      }
    }
    return 0;
  }

  private boolean checkValidation(char aChar) {
    return isNumber(aChar);
  }

  private boolean isNumber(char aChar) {
    return aChar > 47 && aChar < 58;
  }

  private void checkNegative(char aChar) {
    if (aChar == '-') {
      isNegative = true;
    } else if (aChar == '+') {
      isNegative = false;
    } else {
      isNegative = false;
    }
  }
}
