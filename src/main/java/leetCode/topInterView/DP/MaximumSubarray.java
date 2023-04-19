package leetCode.topInterView.DP;

import java.util.Arrays;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.DP
 * @since : 2023/04/18
 */
public class MaximumSubarray {
  public static void main(String[] args) {
    MaximumSubarrayInterface solution = getMaximumSubarraySolution();
    int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(solution.maxSubArray(nums));
  }

  private static MaximumSubarrayInterface getMaximumSubarraySolution() {
    return new MaximumSubarraySolution();
  }
}

class MaximumSubarraySolution implements MaximumSubarrayInterface {
  @Override
  public int maxSubArray(int[] nums) {
    int maxSum = nums[0]; // 초기값은 첫 번째 원소로 설정
    int currentSum = nums[0];

    for (int i = 1; i < nums.length; i++) {
      currentSum = Math.max(nums[i], currentSum + nums[i]);
      // (이전까지의 합 + 현재 원소) vs (현재 원소) 중 더 큰 값을 선택
      maxSum = Math.max(maxSum, currentSum);
      // 현재까지의 최대값보다 크면 최대값을 갱신
    }

    return maxSum;
  }

  @Override
  public int[] subArray(int[] nums) {
    int maxSoFar = nums[0];
    int maxEndingHere = nums[0];
    int start = 0;
    int end = 0;
    int s = 0;

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > maxEndingHere + nums[i]) {
        maxEndingHere = nums[i];
        s = i;
      } else {
        maxEndingHere += nums[i];
      }

      if (maxEndingHere > maxSoFar) {
        maxSoFar = maxEndingHere;
        start = s;
        end = i;
      }
    }

    return Arrays.copyOfRange(nums, start, end + 1);
  }
}

class MaximumSubarraySolution2 implements MaximumSubarrayInterface {
  @Override
  public int maxSubArray(int[] nums) {
    return 0;
  }

  @Override
  public int[] subArray(int[] nums) {
    return new int[0];
  }
}

interface MaximumSubarrayInterface {
  int maxSubArray(int[] nums);
  int[] subArray(int[] nums);
}
