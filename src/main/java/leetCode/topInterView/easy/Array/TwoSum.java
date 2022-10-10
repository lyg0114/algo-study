package leetCode.topInterView.easy.Array;

/*

  Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
  You may assume that each input would have exactly one solution, and you may not use the same element twice.
  You can return the answer in any order.

  Input: nums = [2,7,11,15], target = 9
  Output: [0,1]
  Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

  Input: nums = [3,2,4], target = 6
  Output: [1,2]

  Input: nums = [3,3], target = 6
  Output: [0,1]

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

