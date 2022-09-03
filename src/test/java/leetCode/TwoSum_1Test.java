package leetCode;

import static org.junit.Assert.*;
import org.junit.Test;

public class TwoSum_1Test  {
  @Test
  public void TESTtwoSum(){
    int[] nums = {3,2,4};
    Solution solution = new Solution();
    int[] result = solution.twoSum(nums, 6);
    assertEquals(1, result[0]);
    assertEquals(2, result[1]);
  }
}