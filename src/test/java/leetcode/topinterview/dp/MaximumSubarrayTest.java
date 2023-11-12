package leetcode.topinterview.dp;

import java.util.Arrays;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.DP
 * @since : 2023/04/19
 */
public class MaximumSubarrayTest {

  private MaximumSubarrayInterface getMaximumSubarraySolution() {
    return new MaximumSubarraySolution();
  }

  private void prtintArr(int[] nums) {
    Arrays.stream(nums).forEach(System.out::println);
  }

  @Test
  public void tewtCase1() {
    MaximumSubarrayInterface solution = getMaximumSubarraySolution();
    int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(solution.maxSubArray(nums));
  }

  @Test
  public void tewtCase2() {
    MaximumSubarrayInterface solution = getMaximumSubarraySolution();
    int[] nums = {5, 4, -1, 7, 8};
    System.out.println(solution.maxSubArray(nums));
  }

  @Test
  public void tewtCase3() {
    MaximumSubarrayInterface solution = getMaximumSubarraySolution();
    int[] nums = {1, 2, 3, 4, -10, 20};
    System.out.println(solution.maxSubArray(nums));
  }
}