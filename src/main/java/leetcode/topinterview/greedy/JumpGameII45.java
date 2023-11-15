package leetcode.topinterview.greedy;

/**
 * @author : iyeong-gyo
 * @package : leetcode.topinterview.greedy
 * @@url : https://leetcode.com/problems/jump-game-ii/description/
 * @since : 14.11.23
 */
public class JumpGameII45 {

  public static void main(String[] args) {
//    int[] nums = {2, 3, 0, 1, 4};
//    int[] nums = {2, 3, 1, 1, 4};
//    int[] nums = {5, 9, 3, 2, 1, 2, 3, 3, 1};
    int[] nums = {3, 2, 1, 4, 2, 3, 4, 5, 6};
    SolutionInterface solution = new SolutionV2();
    int jump = solution.jump(nums);
    System.out.println("jump = " + jump);
  }

  static class SolutionV2 implements SolutionInterface {

    @Override
    public int jump(int[] nums) {
      int n = nums.length;
      if (n == 1) {
        return 0;
      }

      int jumps = 0;
      int currentMaxReach = 0;
      int nextMaxReach = 0;
      for (int i = 0; i < n - 1; i++) {
        nextMaxReach = Math.max(nextMaxReach, i + nums[i]);
        if (i == currentMaxReach) {
          jumps++;
          currentMaxReach = nextMaxReach;
        }
        System.out.println("i = " + i);
        System.out.println("i+nums[i] = " + (i + nums[i]));
        System.out.println("nextMaxReach = " + nextMaxReach);
        System.out.println("currentMaxReach = " + currentMaxReach);
        System.out.println("jumps = " + jumps);
        System.out.println("====================================");
      }
      return jumps;
    }
  }

  static class SolutionV1 implements SolutionInterface {

    @Override
    public int jump(int[] nums) {
      if (nums.length == 0) {
        return 0;
      }

      int minCnt = 0, curCnt = 0;
      for (int i = 1; i <= nums[0]; i++) {
        curCnt = calculateCnt(nums, i);
        if (curCnt > 0) {
          if (minCnt == 0) {
            minCnt = curCnt;
          }
          if (curCnt < minCnt) {
            minCnt = curCnt;
          }
        }
      }
      return minCnt;
    }

    private int calculateCnt(int[] nums, int jumpIndex) {
      if (nums.length == 1) {
        return 0;
      }

      int cnt = 1;
      int curIndex = jumpIndex;
      while (curIndex < nums.length - 1) {
        if (nums[curIndex] > 0) {
          curIndex += nums[curIndex];
          cnt++;
        } else {
          cnt = -1;
          break;
        }
      }
      return cnt;
    }
  }

  interface SolutionInterface {

    int jump(int[] nums);
  }

}
