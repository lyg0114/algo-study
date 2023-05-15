package leetCode.topInterView.others;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.others
 * @since : 2023/05/15
 */
public class NumberOf1Bits {

  public static void main(String[] args) {
    NumberOf1BitsInterface solution = getNumberOf1BitsSolution();
    System.out.println(solution.hammingWeight(00000000000000000000000000001011));
  }

  private static NumberOf1BitsInterface getNumberOf1BitsSolution() {
    return new NumberOf1BitsSolution();
  }

  static class NumberOf1BitsSolution implements NumberOf1BitsInterface {

    @Override
    public int hammingWeight(int n) {
      return 0;
    }
  }

  interface NumberOf1BitsInterface {

    int hammingWeight(int n);
  }
}
