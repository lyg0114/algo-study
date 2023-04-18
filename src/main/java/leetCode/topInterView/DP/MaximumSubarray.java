package leetCode.topInterView.DP;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.DP
 * @since : 2023/04/18
 */
public class MaximumSubarray {
  public static void main(String[] args) {
    MaximumSubarrayInterface solution = getMaximumSubarraySolution();
//    int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int[] nums = {5,4,-1,7,8};
    System.out.println(solution.maxSubArray(nums));
  }

  private static MaximumSubarraySolution getMaximumSubarraySolution() {
    return new MaximumSubarraySolution();
  }
}

class MaximumSubarraySolution implements MaximumSubarrayInterface {
  @Override
  public int maxSubArray(int[] nums) {
    int maxSum = nums[0]; // 초기값은 첫 번째 원소로 설정
    int currentSum = nums[0];

    for (int i = 1; i < nums.length; i++) {
      currentSum = Math.max(nums[i], currentSum + nums[i]); // 이전까지의 합과 현재 원소의 합 중 더 큰 값을 선택
      maxSum = Math.max(maxSum, currentSum); // 현재까지의 최대값보다 크면 최대값을 갱신
    }

    return maxSum;
  }
}

interface MaximumSubarrayInterface {
  int maxSubArray(int[] nums);
}
