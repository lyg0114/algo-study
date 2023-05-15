package leetCode.topInterView.others;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.others
 * @since : 2023/05/15
 */
public class NumberOf1Bits {

  public static void main(String[] args) {
    NumberOf1BitsInterface solution = getNumberOf1BitsSolution();
  }

  private static NumberOf1BitsInterface getNumberOf1BitsSolution() {
    return new NumberOf1BitsSolution();
  }

  static class NumberOf1BitsSolution implements NumberOf1BitsInterface {

    @Override
    public int hammingWeight(int n) {
      int count = 0;
      while (n != 0) {
        count += n & 1;
        n >>>= 1;
      }
      return count;
    }
  }

  interface NumberOf1BitsInterface {

    int hammingWeight(int n);
  }
}
