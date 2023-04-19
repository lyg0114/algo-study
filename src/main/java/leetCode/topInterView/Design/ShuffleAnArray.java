package leetCode.topInterView.Design;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Design
 * @since : 2023/04/19
 */
public class ShuffleAnArray {

  public static void main(String[] args) {
    ShuffleAnArrayInterface solution = getSolution();
  }

  private static ShuffleAnArraySolution getSolution() {
    return new ShuffleAnArraySolution();
  }
}

class ShuffleAnArraySolution implements ShuffleAnArrayInterface {

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
