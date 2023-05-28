package leetCode.topInterView.Strings;

import static org.junit.Assert.assertEquals;

import leetCode.topInterView.Strings.LongestPalindromicSubstring.LongestPalindromicSubstringInterface;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Strings
 * @since : 2023/05/22
 */
public class LongestPalindromicSubstringTest {

  @Test
  public void test_1() {
    String input = "babad";
    LongestPalindromicSubstringInterface solution = LongestPalindromicSubstring.getSolution();
    String result = solution.longestPalindrome(input);
    assertEquals("aba", result);
  }

  @Test
  public void test_2() {
    String input = "qwefdfrlkjasdffd";
    LongestPalindromicSubstringInterface solution = LongestPalindromicSubstring.getSolution();
    String result = solution.longestPalindrome(input);
    assertEquals("dffd", result);
  }

  @Test
  public void test_3() {
    String input = "abba";
    LongestPalindromicSubstringInterface solution = LongestPalindromicSubstring.getSolution();
    String result = solution.longestPalindrome(input);
    assertEquals("abba", result);
  }

  @Test
  public void test_4() {
    String input = "babad";
    LongestPalindromicSubstringInterface solution = LongestPalindromicSubstring.getSolution();
    String result = solution.longestPalindrome(input);
    assertEquals("aba", result);
  }

  @Test
  public void test_5() {
    String input = "cbbd";
    LongestPalindromicSubstringInterface solution = LongestPalindromicSubstring.getSolution();
    String result = solution.longestPalindrome(input);
    assertEquals("bb", result);
  }
}