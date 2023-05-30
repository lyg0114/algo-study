package etc;

import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : etc
 * @since : 2023/05/30
 */
public class BinarySearch {

  @Test
  public void test_BinarySearch() {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
    int i = BinarySearchTree.binarySearch(arr, 4);
    System.out.println("i = " + i);
  }

  public static class BinarySearchTree {

    public static int binarySearch(int[] nums, int target) {
      int left = 0;
      int right = nums.length - 1;

      while (left <= right) {
        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
          return mid;
        }

        if (nums[mid] < target) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }

      return -1;
    }
  }
}
