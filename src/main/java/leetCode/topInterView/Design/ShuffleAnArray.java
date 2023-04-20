package leetCode.topInterView.Design;

import java.util.Arrays;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Design
 * @since : 2023/04/19
 */
public class ShuffleAnArray {

  public static void main(String[] args) {
    ShuffleAnArrayInterface solution = getSolution(null);
  }

  private static ShuffleAnArraySolution getSolution(int[] nums) {
    return new ShuffleAnArraySolution(nums);
  }
}

class ShuffleAnArraySolution implements ShuffleAnArrayInterface {

  private int[] originNums;

  public ShuffleAnArraySolution(int[] nums) {
    this.originNums = nums;
  }

  @Override
  public int[] reset() {
    return Arrays.copyOf(originNums, originNums.length);
  }

  @Override
  public int[] shuffle() {
    return new int[0];
  }
}

interface ShuffleAnArrayInterface {

  int[] reset();

  int[] shuffle();
}
