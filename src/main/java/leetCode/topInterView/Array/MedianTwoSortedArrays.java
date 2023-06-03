package leetCode.topInterView.Array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Array
 * @since : 2023/06/03
 */
public class MedianTwoSortedArrays {

  public static void main(String[] args) {
    MedianTwoSortedArraysInterface solution = getSolution();
    int[] nums1 = {1, 2, 2, 4};
    int[] nums2 = {5, 6, 6, 8};
    double median = solution.findMedianSortedArrays(nums1, nums2);
    System.out.println("median = " + median);
  }

  public static MedianTwoSortedArraysInterface getSolution() {
    return new MedianTwoSortedArraysSolutionV2();
  }

  public static class MedianTwoSortedArraysSolutionV2 implements MedianTwoSortedArraysInterface {

    @Override
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int m = nums1.length;
      int n = nums2.length;
      int totalLength = m + n;
      int[] merged = new int[totalLength];

      int i = 0, j = 0, k = 0;
      while (i < m && j < n) {
        if (nums1[i] <= nums2[j]) {
          merged[k++] = nums1[i++];
        } else {
          merged[k++] = nums2[j++];
        }
      }

      while (i < m) {
        merged[k++] = nums1[i++];
      }

      while (j < n) {
        merged[k++] = nums2[j++];
      }

      if (totalLength % 2 == 0) {
        return (merged[totalLength / 2 - 1] + merged[totalLength / 2]) / 2.0;
      } else {
        return merged[totalLength / 2];
      }
    }

  }

  public static class MedianTwoSortedArraysSolutionV1 implements MedianTwoSortedArraysInterface {

    @Override
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      List<Integer> merg = mergeTwoArr(nums1, nums2);
      if (merg.size() == 0) {
        return 0.0;
      }
      if (merg.size() == 1) {
        return (double) merg.get(0);
      }
      if (merg.size() % 2 == 1) {
        return (double) merg.get(merg.size() / 2);
      } else {
        Integer e1 = merg.get(merg.size() / 2);
        Integer e2 = merg.get((merg.size() / 2) - 1);
        return (double) (e1 + e2) / 2;
      }
    }

    private List<Integer> mergeTwoArr(int[] nums1, int[] nums2) {
      List<Integer> lis1 = converToList(nums1);
      List<Integer> lis2 = converToList(nums2);
      lis1.addAll(lis2);
      return lis1.stream().sorted().collect(Collectors.toList());
    }

    private List<Integer> converToList(int[] arr) {
      ArrayList<Integer> lis = new ArrayList<>();
      if (arr == null) {
        return lis;
      }
      for (int i = 0; i < arr.length; i++) {
        lis.add(arr[i]);
      }
      return lis;
    }
  }

  public interface MedianTwoSortedArraysInterface {

    double findMedianSortedArrays(int[] nums1, int[] nums2);
  }
}
