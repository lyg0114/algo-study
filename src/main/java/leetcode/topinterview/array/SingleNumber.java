package leetcode.topinterview.array;

import java.util.HashMap;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Array
 * @since : 2023/03/02 https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/549/
 */
public class SingleNumber {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4};
    SingleNumberInterface singleNumberSolution = getSolution();
    System.out.println(singleNumberSolution.singleNumber(nums));
  }

  public static SingleNumberSolutionV1 getSolution() {
    return new SingleNumberSolutionV1();
  }

  public static class SingleNumberSolutionV1 implements SingleNumberInterface {

    @Override
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
        if (map.get(num) == 1) {
          return num;
        }
      }
      return -1;
    }
  }

  public interface SingleNumberInterface {

    int singleNumber(int[] nums);
  }
}

