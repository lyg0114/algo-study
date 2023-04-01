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
    String[] strs = {"flower", "flow", "flight"};
    assertEquals("fl", prefix.longestCommonPrefix(strs));
  }
}