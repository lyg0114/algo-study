package leetCode.topInterView.DP;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.DP
 * @since : 2023/04/19
 */
public class HouseRobber {

  public static void main(String[] args) {
    int[] nums = {1, 0, 0, 3};
    HouseRobberInterface solution = getSolution();
    System.out.println(solution.rob(nums));
  }

  private static HouseRobberInterface getSolution() {
    return new HouseRobberSolution();
  }
}

class HouseRobberSolution implements HouseRobberInterface {

  @Override
  public int rob(int[] nums) {
    int n = nums.length;
    if (n == 1) {
      return nums[0];
    }
    if (n == 2) {
      return Math.max(nums[0], nums[1]);
    }

    int[] dp = new int[n];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);

    for (int i = 2; i < n; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
    }

    return dp[n - 1];
  }
}

interface HouseRobberInterface {

  int rob(int[] nums);
}
