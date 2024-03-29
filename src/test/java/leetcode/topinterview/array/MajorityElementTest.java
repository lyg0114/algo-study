package leetcode.topinterview.array;

import static org.junit.Assert.assertEquals;

import leetcode.topinterview.array.MajorityElement.MajorityElementInterface;
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
    int[] nums = {3, 2, 3};
    int expect = 3;
    int actual = solution.majorityElement(nums);
    assertEquals(expect, actual);
  }

  @Test
  public void test_majorityElement_2() {
    MajorityElementInterface solution = MajorityElement.getSolution();
    int[] nums = {2};
    int expect = 2;
    int actual = solution.majorityElement(nums);
    assertEquals(expect, actual);
  }

  @Test
  public void test_majorityElement_3() {
    MajorityElementInterface solution = MajorityElement.getSolution();
    int[] nums = {};
    int expect = 0;
    int actual = solution.majorityElement(nums);
    assertEquals(expect, actual);
  }

  @Test
  public void test_majorityElement_4() {
    MajorityElementInterface solution = MajorityElement.getSolution();
    int[] nums = {-1, -1, -1, -1, -1, -1, 1, 2, 3};
    int expect = -1;
    int actual = solution.majorityElement(nums);
    assertEquals(expect, actual);
  }
}