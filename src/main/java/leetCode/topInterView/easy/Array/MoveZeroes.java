package leetCode.topInterView.easy.Array;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.easy.Array
 * @since : 2023/03/02 https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/567/
 */
public class MoveZeroes {

  public static void main(String[] args) {
    int[] nums = {0, 1, 0, 3, 12};
    MoveZeroesSolution solution = new MoveZeroesSolution();
    for (int i = 0; i < nums.length; i++) {
      System.out.print(nums[i] + ",");
    }
    solution.moveZeroes(nums);
    System.out.println("");
    for (int i = 0; i < nums.length; i++) {
      System.out.print(nums[i] + ",");
    }
  }
}

class MoveZeroesSolution {

  public void moveZeroes(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      change(nums, i);
    }
  }

  public void change(int[] nums, int index) {
    if (index == nums.length - 1) {
      return;
    }

    if (nums[index] == 0) {
      int tmp = nums[index + 1];
      nums[index + 1] = nums[index];
      nums[index] = tmp;
      change(nums, ++index);
    }

  }
}



















