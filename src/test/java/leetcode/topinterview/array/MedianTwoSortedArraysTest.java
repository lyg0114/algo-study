package leetcode.topinterview.array;

import static org.junit.Assert.*;

import leetcode.topinterview.array.MedianTwoSortedArrays.MedianTwoSortedArraysInterface;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Array
 * @since : 2023/06/03
 */
public class MedianTwoSortedArraysTest {

  @Test
  public void test_findMedianSortedArrays_1() {
    MedianTwoSortedArraysInterface solution = MedianTwoSortedArrays.getSolution();
    int[] nums1 = {1, 2};
    int[] nums2 = {3, 4};
    double expected = 2.50000;
    double delta = 0.00001; // 허용 오차 범위
    double actual = solution.findMedianSortedArrays(nums1, nums2);
    assertEquals(expected, actual, delta);
  }

  @Test
  public void test_findMedianSortedArrays_2() {
    MedianTwoSortedArraysInterface solution = MedianTwoSortedArrays.getSolution();
    int[] nums1 = {1};
    int[] nums2 = {3, 4};
    double expected = 3.0;
    double delta = 0.00001; // 허용 오차 범위
    double actual = solution.findMedianSortedArrays(nums1, nums2);
    assertEquals(expected, actual, delta);
  }
}