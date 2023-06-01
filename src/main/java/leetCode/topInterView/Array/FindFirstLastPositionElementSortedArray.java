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
          if (nums.length == 1) {
            res[0] = m;
            res[1] = m;
            break;
          }

          if (m > 0 && nums[m] == nums[m - 1]) {
            res[0] = m - 1;
            res[1] = m;
          } else if (m < nums.length - 1 && nums[m] == nums[m + 1]) {
            res[0] = m;
            res[1] = m + 1;
          } else {
            res[0] = m;
            res[1] = m;
          }

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
  }

  public interface FindFirstLastPositionElementSortedArrayInterface {

    int[] searchRange(int[] nums, int target);
  }
}
