package leetCode.topInterView.DP;

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
  public void tewtCase1(){
    MaximumSubarrayInterface solution = getMaximumSubarraySolution();
    int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int[] results = solution.subArray(nums);
    prtintArr(results);
  }

  @Test
  public void tewtCase2(){
    MaximumSubarrayInterface solution = getMaximumSubarraySolution();
    int[] nums = {5,4,-1,7,8};
    int[] results = solution.subArray(nums);
    prtintArr(results);
  }
}