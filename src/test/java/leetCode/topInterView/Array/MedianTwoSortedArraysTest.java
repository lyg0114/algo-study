package leetCode.topInterView.Array;

import static org.junit.Assert.*;

import leetCode.topInterView.Array.MedianTwoSortedArrays.MedianTwoSortedArraysInterface;
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
    int[] nums1 = new int[10];
    int[] nums2 = new int[10];
    double expect = 2.00000;
    double actual = solution.findMedianSortedArrays(nums1, nums2);
    assertEquals(expect, actual);
  }
}