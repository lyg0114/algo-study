package leetCode.topInterView.Strings;

import static org.junit.Assert.*;

import leetCode.topInterView.Strings.LongestPalindromicSubstring.LongestPalindromicSubstringInterface;
import leetCode.topInterView.Strings.LongestPalindromicSubstring.LongestPalindromicSubstringSolutionV2;
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
    System.out.println("result = " + result);
  }

  @Test
  public void test_2() {
    String input = "qwefdfrlkjasdf";
    LongestPalindromicSubstringInterface solution = LongestPalindromicSubstring.getSolution();
    String result = solution.longestPalindrome(input);
    System.out.println("result = " + result);
  }

  @Test
  public void test_3() {
    String input = "abba";
    LongestPalindromicSubstringInterface solution = LongestPalindromicSubstring.getSolution();
    String result = solution.longestPalindrome(input);
    System.out.println("result = " + result);
  }

  @Test
  public void test_expandAroundCenter_1() {
    String input = "alsdkdffdjhba";
    LongestPalindromicSubstringSolutionV2 solution = new LongestPalindromicSubstringSolutionV2();
    int i = solution.expandAroundCenter(input, 6, 7);
    System.out.println("i = " + i);
  }

  @Test
  public void test_substr(){
    String test = "123adfda978";
    String substring = test.substring(0, 2);
    System.out.println("substring = " + substring);
  }

}