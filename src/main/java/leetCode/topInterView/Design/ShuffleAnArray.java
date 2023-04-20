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

  private int[] originNums;
  private int[] nums;

  public ShuffleAnArraySolution(int[] nums) {
    this.originNums = nums;
    this.nums = nums;
  }

  @Override
  public int[] reset() {
    nums = Arrays.copyOf(originNums, originNums.length);
    return nums;
  }

  @Override
  public int[] shuffle() {
    Random random = new Random();
    int temp;
    for (int i = 0; i < nums.length; i++) {
      int chnageIndex = random.nextInt(nums.length);
      temp = nums[i];
      nums[i] = nums[chnageIndex];
      nums[chnageIndex] = temp;
    }
    return nums;
  }
}

interface ShuffleAnArrayInterface {

  int[] reset();

  int[] shuffle();
}
