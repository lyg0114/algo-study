package leetCode.topInterView.Strings;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Strings
 * @since : 2023/04/01
 */
public class LongestCommonPrefixTest {

  @Test
  public void testCase1() {
    LongestCommonPrefixSolution2 prefix = new LongestCommonPrefixSolution2();
    String[] strs = {"dog", "racecar", "car"};
    assertEquals("", prefix.longestCommonPrefix(strs));
  }

  @Test
  public void testCase2() {
    LongestCommonPrefixSolution2 prefix = new LongestCommonPrefixSolution2();
    String[] strs = {"", "b"};
    assertEquals("", prefix.longestCommonPrefix(strs));
  }

  @Test
  public void testCase3() {
    LongestCommonPrefixSolution2 prefix = new LongestCommonPrefixSolution2();
    String[] strs = {"cir", "car"};
    assertEquals("c", prefix.longestCommonPrefix(strs));
  }

  @Test
  public void testCase4() {
    LongestCommonPrefixSolution2 prefix = new LongestCommonPrefixSolution2();
    String[] strs = {"flower", "flow", "flight"};
    assertEquals("fl", prefix.longestCommonPrefix(strs));
  }

  @Test
  public void testIndexOf() {
    String strs = "xxflower";
    String target = "flo";
    System.out.println(strs.indexOf(target));
    System.out.println(target.indexOf(strs));
  }
}