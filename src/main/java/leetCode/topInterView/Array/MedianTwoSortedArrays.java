package leetCode.topInterView.Array;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Array
 * @since : 2023/06/03
 */
public class MedianTwoSortedArrays {

  public static void main(String[] args) {
    MedianTwoSortedArraysInterface solution = getSolution();
    int[] nums1 = new int[10];
    int[] nums2 = new int[10];
    double median = solution.findMedianSortedArrays(nums1, nums2);
    System.out.println("median = " + median);
  }

  public static MedianTwoSortedArraysInterface getSolution() {
    return new MedianTwoSortedArraysSolutionV1();
  }

  public static class MedianTwoSortedArraysSolutionV1 implements MedianTwoSortedArraysInterface {

    @Override
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      return 0;
    }
  }

  public interface MedianTwoSortedArraysInterface {

    double findMedianSortedArrays(int[] nums1, int[] nums2);
  }
}
