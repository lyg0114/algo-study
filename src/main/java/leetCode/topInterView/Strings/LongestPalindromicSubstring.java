package leetCode.topInterView.Strings;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Strings
 * @since : 2023/05/22
 */
public class LongestPalindromicSubstring {

  public static void main(String[] args) {
    LongestPalindromicSubstringInterface solution = getSolution();
    String input = "babad";
    String output = solution.longestPalindrome(input);
    System.out.println("output = " + output);
  }

  private static LongestPalindromicSubstringInterface getSolution() {
    return new LongestPalindromicSubstringSolution();
  }

  public static class LongestPalindromicSubstringSolution implements
      LongestPalindromicSubstringInterface {

    @Override
    public String longestPalindrome(String s) {
      return null;
    }
  }

  interface LongestPalindromicSubstringInterface {

    String longestPalindrome(String s);
  }
}
