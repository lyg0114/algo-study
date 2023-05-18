package leetCode.topInterView.Array;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Array
 * @since : 2023/03/02 https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/646/
 */
public class RotateArray {

  public static void main(String[] args) {
    RotateArrayInterface solution = getSolution();
    int[] nums = {1,2,3,4};
    int k = 2;
    solution.rotate(nums, k);
    for (int i = 0; i < nums.length; i++) {
      System.out.println(nums[i]);
    }
  }

  public static RotateArrayInterface getSolution() {
    return new RotateArraySolutionV1();
  }

  public static class RotateArraySolutionV1 implements RotateArrayInterface {

    @Override
    public void rotate(int[] nums, int k) {
      if (nums == null || k < 1) {
        return;
      }

      int last;
      for (int i = 0; i < k; i++) {
        last = nums[nums.length - 1];
        int before;
        for (int j = nums.length - 1; j > 0; j--) {
          nums[j] = nums[j - 1];
        }
        nums[0] = last;
      }
    }
  }

  public static class RotateArraySolutionV2 implements RotateArrayInterface {

    @Override
    public void rotate(int[] nums, int k) {
    }
  }

  interface RotateArrayInterface {

    void rotate(int[] nums, int k);
  }
}
