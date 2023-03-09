package leetCode.topInterView.easy.Strings;

import java.util.ArrayList;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.easy.Strings
 * @since : 2023/03/09
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/883/
 */
public class ValidPalindrome {

  public static void main(String[] args) {
    String str = "A man, a plan, a canal: Panama";
//    String str = "race a car";
    ValidPalindromeSolution solution = new ValidPalindromeSolution();
    System.out.println(solution.isPalindrome(str));
  }
}

class ValidPalindromeSolution {

  public boolean isPalindrome(String s) {
    ArrayList<Character> targets = new ArrayList<>();
    String s1 = s.toLowerCase();
    char[] chars = s1.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (isLetter(chars[i]) || isNumber(chars[i])) {
        targets.add(chars[i]);
      }
    }

    for (int i = 0; i < targets.size() / 2; i++) {
      if (targets.get(i) != targets.get(targets.size() - i - 1)) {
        return false;
      }
    }
    return true;
  }

  private boolean isNumber(char aChar) {
    return aChar > 47 && aChar < 58;
  }

  private boolean isLetter(char aChar) {
    return aChar > 96 && aChar < 123;
  }
}
