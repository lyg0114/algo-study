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
      return null;
    }
  }

  public interface FindFirstLastPositionElementSortedArrayInterface {

    int[] searchRange(int[] nums, int target);
  }
}
