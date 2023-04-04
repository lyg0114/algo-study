package leetCode.topInterView.Array;

/*
  https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/546/
 */

public class TwoSum {

  public static void main(String[] args) {
    int[] nums = {3,2,4};
    TwoSum twoSum = new TwoSum();
    int[] result =twoSum.twoSum(nums, 6);
    for (int i : result) {
      System.out.println("i = " + i);
    }
  }

  public int[] twoSum(int[] nums, int target) {
    return travels(nums, target);
  }

  public int[] travels(int[] nums, int target) {
    int startIndex = 0;
    for (int i = startIndex; i < nums.length; i++) {
      if (startIndex != nums.length) {
        for (int j = startIndex; j < nums.length; j++) {
          if (i !=j && nums[i] + nums[j] == target) {
            return new int[]{i, j};
          }
        }
        startIndex++;
      }
    }
    return new int[]{};
  }
}

