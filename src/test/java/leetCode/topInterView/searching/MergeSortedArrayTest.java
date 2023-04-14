package leetCode.topInterView.searching;

import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.searching
 * @since : 2023/04/14
 */
public class MergeSortedArrayTest {

  private MergeSortedArraySolution getSolution() {
    return new MergeSortedArraySolution();
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
}