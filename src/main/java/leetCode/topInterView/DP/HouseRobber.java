package leetCode.topInterView.DP;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.DP
 * @since : 2023/04/19
 */
public class HouseRobber {

  public static void main(String[] args) {
    int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
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
    return 0;
  }
}

interface HouseRobberInterface {

  int rob(int[] nums);
}
