package leetcode.topinterview.searching;

import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.searching
 * @since : 2023/04/14
 */
public class MergeSortedArrayTest {

  private MergeSortedArrayInterface getSolution() {
    return new MergeSortedArraySolution2();
  }

  @Test
  public void testCase1() {
    int nums1[] = {1, 2, 3, 0, 0, 0};
    int nums2[] = {2, 5, 6};
    MergeSortedArrayInterface solution = getSolution();
    solution.merge(nums1, 3, nums2, 3);
    for (int i = 0; i < nums1.length; i++) {
      System.out.println("nums1[i] : " + nums1[i]);
    }
  }

  @Test
  public void testCase2() {
    int nums1[] = {1, 2, 3, 0, 0, 0};
    int nums2[] = {5, 6, 7};
    MergeSortedArrayInterface solution = getSolution();
    solution.merge(nums1, 3, nums2, 3);
    for (int i = 0; i < nums1.length; i++) {
      System.out.println("nums1[i] : " + nums1[i]);
    }
  }

  @Test
  public void testCase3() {
    int nums1[] = {5, 6, 7, 0, 0, 0};
    int nums2[] = {1, 2, 3};
    MergeSortedArrayInterface solution = getSolution();
    solution.merge(nums1, 3, nums2, 3);
    for (int i = 0; i < nums1.length; i++) {
      System.out.println("nums1[i] : " + nums1[i]);
    }
  }

  @Test
  public void testCase4() {
    int nums1[] = {1, 2, 3, 0, 0, 0};
    int nums2[] = {1, 2, 3};
    MergeSortedArrayInterface solution = getSolution();
    solution.merge(nums1, 3, nums2, 3);
    for (int i = 0; i < nums1.length; i++) {
      System.out.println("nums1[i] : " + nums1[i]);
    }
  }
}




























