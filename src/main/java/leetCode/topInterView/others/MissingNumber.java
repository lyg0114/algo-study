package leetCode.topInterView.others;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.others
 * @since : 2023/05/16
 */
public class MissingNumber {

  public static void main(String[] args) {
    MissingNumberInterface solution = getSolution();
    int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
    int i = solution.missingNumber(nums);
    System.out.println("i = " + i);
  }

  private static MissingNumberInterface getSolution() {
    return new MissingNumberSolution();
  }

  public static class MissingNumberSolution implements MissingNumberInterface {

    @Override
    public int missingNumber(int[] nums) {
      int[] results = new int[nums.length + 1];
      for (int i = 0; i < nums.length; i++) {
        results[nums[i]] += 1;
      }
      for (int i = 0; i < results.length; i++) {
        if (results[i] == 0) {
          return i;
        }
      }
      return 0;
    }
  }

  interface MissingNumberInterface {

    int missingNumber(int[] nums);
  }
}
