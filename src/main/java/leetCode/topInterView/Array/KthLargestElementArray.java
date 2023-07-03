package leetCode.topInterView.Array;

import java.util.Random;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Array
 * @since : 2023/06/22
 */
public class KthLargestElementArray {

  public static void main(String[] args) {
    KthLargestElementArrayInterface solution = getSolution();
    int[] nums = {3, 2, 1, 5, 6, 4};
    int kthLargest = solution.findKthLargest(nums, 2);
    System.out.println("kthLargest = " + kthLargest);
  }

  public static KthLargestElementArrayInterface getSolution() {
    return new KthLargestElementArraySolutionV1();
  }

  public static class KthLargestElementArraySolutionV2 implements KthLargestElementArrayInterface {

    public int findKthLargest(int[] nums, int k) {
      return quickSelect(nums, 0, nums.length - 1, k);
    }

    int quickSelect(int[] nums, int low, int high, int k) {
      int pivot = low;

      // use quick sort's idea
      // put nums that are <= pivot to the left
      // put nums that are  > pivot to the right
      for (int j = low; j < high; j++) {
        if (nums[j] <= nums[high]) {
          swap(nums, pivot++, j);
        }
      }
      swap(nums, pivot, high);

      // count the nums that are > pivot from high
      int count = high - pivot + 1;
      // pivot is the one!
      if (count == k) {
        return nums[pivot];
      }
      // pivot is too small, so it must be on the right
      if (count > k) {
        return quickSelect(nums, pivot + 1, high, k);
      }
      // pivot is too big, so it must be on the left
      return quickSelect(nums, low, pivot - 1, k - count);
    }

    private void swap(int[] nums, int i, int j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
    }
  }

  public static class KthLargestElementArraySolutionV1 implements KthLargestElementArrayInterface {

    private static Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
      int left = 0;
      int right = nums.length - 1;

      int targetIndex = nums.length - k;

      while (left <= right) {
        int pivotIndex = partition(nums, left, right);
        if (pivotIndex == targetIndex) {
          return nums[pivotIndex];
        } else if (pivotIndex < targetIndex) {
          left = pivotIndex + 1;
        } else {
          right = pivotIndex - 1;
        }
      }

      return -1;
    }

    private int partition(int[] nums, int left, int right) {
      int randomIndex = random.nextInt(right - left + 1) + left;
      swap(nums, randomIndex, right);

      int pivot = nums[right];
      int i = left - 1;

      for (int j = left; j < right; j++) {
        if (nums[j] <= pivot) {
          i++;
          swap(nums, i, j);
        }
      }

      swap(nums, i + 1, right);
      return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
    }
  }

  public interface KthLargestElementArrayInterface {

    int findKthLargest(int[] nums, int k);
  }
}
