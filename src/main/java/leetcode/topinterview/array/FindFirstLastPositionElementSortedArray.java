package leetcode.topinterview.array;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Array
 * @url : https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * @since : 2023/05/31
 */
public class FindFirstLastPositionElementSortedArray {

  public static void main(String[] args) {
    FindFirstLastPositionElementSortedArrayInterface solution = getSolution();
    int[] arr = {5, 7, 7, 8, 8, 10};
    int target = 8;
    int[] actuals = solution.searchRange(arr, target);
    System.out.println("actuals = " + actuals);
  }

  public static FindFirstLastPositionElementSortedArrayInterface getSolution() {
    return new FindFirstLastPositionElementSortedArraySolutionV1();
  }

  public static class FindFirstLastPositionElementSortedArraySolutionV1 implements
      FindFirstLastPositionElementSortedArrayInterface {

    @Override
    public int[] searchRange(int[] nums, int target) {
      int l = 0;
      int r = nums.length - 1;
      int m;
      int[] res = {-1, -1};

      while (l <= r) {
        m = (l + r) / 2;
        if (nums[m] == target) {
          res[0] = checkLeft(m, target, nums);
          res[1] = checkright(m, target, nums);
          break;
        }

        if (nums[l] <= target && target < nums[m]) {
          r = m - 1;
        } else {
          l = m + 1;
        }
      }

      return res;
    }

    private int checkLeft(int m, int target, int[] nums) {
      if (m == 0) {
        return m;
      }

      for (int i = m; i >= 0; i--) {
        if (target != nums[i]) {
          return i + 1;
        }
      }
      return 0;
    }

    private int checkright(int m, int target, int[] nums) {
      if (m == nums.length - 1) {
        return m;
      }
      for (int i = m; i < nums.length; i++) {
        if (target != nums[i]) {
          return i - 1;
        }
      }
      return nums.length - 1;
    }
  }

  public static class FindFirstLastPositionElementSortedArraySolutionV2 implements
      FindFirstLastPositionElementSortedArrayInterface {

    @Override
    public int[] searchRange(int[] nums, int target) {
      int[] result = {-1, -1};
      int start = findFirstPosition(nums, target);

      if (start == -1) {
        return result;
      }

      int end = findLastPosition(nums, target);
      result[0] = start;
      result[1] = end;

      return result;
    }

    private int findFirstPosition(int[] nums, int target) {
      int start = 0;
      int end = nums.length - 1;
      int position = -1;

      while (start <= end) {
        int mid = start + (end - start) / 2;

        if (nums[mid] >= target) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }

        if (nums[mid] == target) {
          position = mid;
        }
      }

      return position;
    }

    private int findLastPosition(int[] nums, int target) {
      int start = 0;
      int end = nums.length - 1;
      int position = -1;

      while (start <= end) {
        int mid = start + (end - start) / 2;

        if (nums[mid] <= target) {
          start = mid + 1;
        } else {
          end = mid - 1;
        }

        if (nums[mid] == target) {
          position = mid;
        }
      }

      return position;
    }
  }

  public interface FindFirstLastPositionElementSortedArrayInterface {

    int[] searchRange(int[] nums, int target);
  }
}
