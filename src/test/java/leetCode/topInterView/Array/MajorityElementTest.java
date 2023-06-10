package leetCode.topInterView.Array;

import static org.junit.Assert.*;

import leetCode.topInterView.Array.MajorityElement.MajorityElementInterface;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Array
 * @since : 2023/06/10
 */
public class MajorityElementTest {

  @Test
  public void test_majorityElement_1() {
    MajorityElementInterface solution = MajorityElement.getSolution();
    int[] nums = {1, 2, 3};
    int expect = 3;
    int actual = solution.majorityElement(nums);
    assertEquals(expect, actual);
  }
}