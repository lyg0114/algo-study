package leetCode.topInterView.easy.Array.moveZero;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.easy.Array
 * @since : 2023/03/02 https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/567/
 */
public class MoveZeroes {
  public static void main(String[] args) {
    int[] nums = {0,1,0,3,12};
    MoveZeroesSolutionInterface solution
        = new MoveZeroesMoveZeroesSolution2();
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



















