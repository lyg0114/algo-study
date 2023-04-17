package leetCode.topInterView.DP;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.DP
 * @since : 2023/04/17
 */
public class ClimbingStairs {

  public static void main(String[] args) {
    ClimbingStairsInterface solution = new ClimbingStairsSolution();
    solution.climbStairs(4);
  }

  private static class ClimbingStairsSolution implements ClimbingStairsInterface {

    @Override
    public int climbStairs(int n) {
      if (n == 1) {
        return 1;
      }
      int[] dp = new int[n + 1];
      dp[1] = 1;
      dp[2] = 2;
      for (int i = 3; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
      }
      return dp[n];
    }
  }

  private interface ClimbingStairsInterface {

    int climbStairs(int n);
  }
}
