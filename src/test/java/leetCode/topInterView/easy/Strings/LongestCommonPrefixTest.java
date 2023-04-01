package leetCode.topInterView.easy.Strings;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.easy.Strings
 * @since : 2023/04/01
 */
public class LongestCommonPrefixTest {

  @Test
  public void testCase1() {
    LongestCommonPrefixSolution prefix = new LongestCommonPrefixSolution();
    String[] strs = {"flow", "xxxflower", "flozzflower", "flower", "flight"};
    assertEquals("fl", prefix.longestCommonPrefix(strs));
  }

  @Test
  public void testCase2() {
    LongestCommonPrefixSolution prefix = new LongestCommonPrefixSolution();
    String[] strs = {"dog", "racecar", "car"};
    assertEquals("", prefix.longestCommonPrefix(strs));
  }

  @Test
  public void testCase3() {
    LongestCommonPrefixSolution prefix = new LongestCommonPrefixSolution();
    String[] strs = {"", "b"};
    assertEquals("", prefix.longestCommonPrefix(strs));
  }

  @Test
  public void testCase4() {
    LongestCommonPrefixSolution prefix = new LongestCommonPrefixSolution();
    String[] strs = {"cir", "car"};
    assertEquals("c", prefix.longestCommonPrefix(strs));
  }

}