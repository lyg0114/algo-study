package leetCode.topInterView.Design;

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

  private int[] nums;

  public ShuffleAnArraySolution(int[] nums) {
    this.nums = nums;
  }

  @Override
  public int[] reset() {
    return new int[0];
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
