package leetCode;

import static org.junit.Assert.*;
import org.junit.Test;

public class TwoSum_1Test  {

  @Test
  public void test(){
    int[] nums = {2,7,11,15};
    Solution solution = new Solution();
    int[] result = solution.twoSum(nums, 9);
    assertEquals(result[0] + result[1] ,9);
  }

}