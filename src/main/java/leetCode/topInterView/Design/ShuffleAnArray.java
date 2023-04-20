package leetCode.topInterView.Design;

import java.util.Arrays;
import java.util.Random;

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
  private Random random;

  public ShuffleAnArraySolution(int[] nums) {
    this.nums = nums;
    this.random = new Random();
  }

  @Override
  public int[] reset() {
    return nums;
  }

  @Override
  public int[] shuffle() {
    int[] shuffled = nums.clone();
    for (int i = 0; i < nums.length; i++) {
      int j = random.nextInt(nums.length - i) + i;
      int temp = shuffled[i];
      shuffled[i] = shuffled[j];
      shuffled[j] = temp;
    }
    return shuffled;
  }
}

interface ShuffleAnArrayInterface {

  int[] reset();

  int[] shuffle();
}
