package leetcode.topinterview.array;

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
