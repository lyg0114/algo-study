package leetCode.topInterView.Strings;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Strings
 * @since : 2023/05/22
 */
public class LongestPalindromicSubstring {

  public static void main(String[] args) {
    LongestPalindromicSubstringInterface solution = getSolution();
//    String input = "babad";
//    String input = "cbbd";
    String input = "ab";
    String output = solution.longestPalindrome(input);
    System.out.println("output = " + output);
  }

  private static LongestPalindromicSubstringInterface getSolution() {
    return new LongestPalindromicSubstringSolutionV1();
  }

  public static class LongestPalindromicSubstringSolutionV1 implements
      LongestPalindromicSubstringInterface {

    @Override
    public String longestPalindrome(String s) {
      if (s == null || s.length() == 1) {
        return s;
      }
      if (s.length() == 2) {
        if (s.charAt(0) == s.charAt(1)) {
          return s;
        } else {
          return String.valueOf(s.charAt(0));
        }
      }

      int length = s.length();
      for (int i = length; i > 0; i--) {
        int start = 0;
        int end = i;
        while (end < length) {
          int innerStart = start;
          int innerEnd = end + 1;
          StringBuffer sb = new StringBuffer();
          while (innerStart < innerEnd) {
            sb.append(s.charAt(innerStart++));
          }
          String str = sb.toString();
          if (isPalindromStr(str)) {
            return str;
          }
          start++;
          end++;
        }
      }

      return "";
    }

    private boolean isPalindromStr(String str) {
      int start = 0;
      int end = str.length() - 1;
      while (start < end) {
        if (str.charAt(start++) != str.charAt(end--)) {
          return false;
        }
      }
      return true;
    }
  }

  interface LongestPalindromicSubstringInterface {

    String longestPalindrome(String s);
  }
}
