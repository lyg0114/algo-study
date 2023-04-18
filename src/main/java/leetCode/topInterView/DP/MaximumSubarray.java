package leetCode.topInterView.DP;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.DP
 * @since : 2023/04/18
 */
public class MaximumSubarray {
  public static void main(String[] args) {
    MaximumSubarrayInterface solution = getMaximumSubarraySolution();
    int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
    System.out.println(solution.maxSubArray(nums));
  }

  private static MaximumSubarraySolution getMaximumSubarraySolution() {
    return new MaximumSubarraySolution();
  }
}

class MaximumSubarraySolution implements MaximumSubarrayInterface {
  @Override
  public int maxSubArray(int[] nums) {
    return 0;
  }
}

interface MaximumSubarrayInterface {
  int maxSubArray(int[] nums);
}
