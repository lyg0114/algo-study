package leetCode.topInterView.searching;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.searching
 * @url : https://leetcode.com/explore/featured/card/top-interview-questions-easy/96/sorting-and-searching/587/
 * @since : 2023/04/14
 */
public class MergeSortedArray {

  public static void main(String[] args) {
    int nums1[] = {1, 2, 3, 0, 0, 0};
    int nums2[] = {2, 5, 6};
    MergeSortedArrayInterface solution = new MergeSortedArraySolution();
    solution.merge(nums1, 3, nums2, 3);
    for (int i = 0; i < nums1.length; i++) {
      System.out.println("nums1[i] : " + nums1[i]);
    }
  }
}

class MergeSortedArraySolution implements MergeSortedArrayInterface {

  @Override
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1; // declare i whcih is index of array nums1
    int j = n - 1; // declare j which is index of array nums2
    int k = m + n - 1; // delcare k which is index of entire of array
    while (i >= 0 && j >= 0) { // while roop run when i,j is greater than 0
      if (nums1[i] >= nums2[j]) { // if nums1[i] is greater than nums2[j]
        nums1[k--] = nums1[i--]; // Copy the i-th element of the nums1 array to the k-th position. Then, decrease i and k by 1 each.
      } else {
        nums1[k--] = nums2[j--];
      }
    }

    while (j >= 0) {
      nums1[k--] = nums2[j--];
    }
  }
}

class MergeSortedArraySolution2 implements MergeSortedArrayInterface {

  @Override
  public void merge(int[] nums1, int m, int[] nums2, int n) {
  }
}

interface MergeSortedArrayInterface {
  void merge(int[] nums1, int m, int[] nums2, int n);
}
































