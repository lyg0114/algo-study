package leetcode;

import static org.junit.Assert.*;

import leetcode.topinterview.array.TwoSum;
import org.junit.Test;

public class TwoSum_Test {
  @Test
  public void TESTtwoSum(){
    int[] nums = {3,2,4};
    TwoSum twoSum = new TwoSum();
    int[] result =twoSum.twoSum(nums, 6);
    assertEquals(1, result[0]);
    assertEquals(2, result[1]);
  }
}