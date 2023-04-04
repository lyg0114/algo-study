package leetCode.topInterView.Array;

import java.util.HashMap;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Array
 * @since : 2023/03/02 https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/549/
 */
public class SingleNumber {

  public static void main(String[] args) {
    int[] nums = {1,2,3,4};
    SingleNumberSolution singleNumberSolution = new SingleNumberSolution();
    System.out.println(singleNumberSolution.singleNumber(nums));
  }
}

class SingleNumberSolution {

  public int singleNumber(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        map.replace(nums[i], map.get(nums[i]) + 1);
      } else {
        map.put(nums[i], 1);
      }
    }
    for (Integer num : map.keySet()) {
      if (map.get(num) == 1)
        return num;
    }
    return -1;
  }
}
