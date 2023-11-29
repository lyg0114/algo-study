package leetcode.topinterview.greedy;

/**
 * @author : iyeong-gyo
 * @package : leetcode.topinterview.greedy
 * @since : 29.11.23
 */
public class JumpGame55 {

  public static void main(String[] args) {
    Solution solution = new SolutionV1();
//    int[] nums = {2, 3, 1, 1, 4};
//    int[] nums = {3, 2, 1, 0, 4};
//    int[] nums = {1,1,1,1,1};
//    int[] nums = {1, 1, 1, 1, 0};
//    int[] nums = {5, 2, 1};
    int[] nums = {3, 0, 8, 2, 0, 0, 1};
    boolean result = solution.canJump(nums);
    System.out.println("result = " + result);
  }

  static class SolutionV1 implements Solution {

    public boolean canJump(int[] nums) {
      if (nums.length == 1) {
        return true;
      }
      int maxJump, deadline = 0;
      for (int i = 0; i < nums.length; i++) {
        maxJump = nums[i];
        deadline = Math.max(i + maxJump, deadline);
        if (deadline >= nums.length - 1) {
          return true;
        }
        if (deadline == i && deadline < nums.length - 1) {
          return false;
        }
      }
      return false;
    }
  }

  interface Solution {

    boolean canJump(int[] nums);
  }
}
