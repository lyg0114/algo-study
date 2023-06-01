package leetCode.topInterView.Array;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Array
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

  public interface FindFirstLastPositionElementSortedArrayInterface {

    int[] searchRange(int[] nums, int target);
  }
}
