package leetCode.topInterView.others;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.others
 * @since : 2023/05/30
 */
public class DivideTwoIntegers {

  public static void main(String[] args) {
    int dividend = 10;
    int divisor = 3;
    DivideTwoIntegersInterface solution = getSolution();
    int divide = solution.divide(10, 3);
    System.out.println("divide = " + divide);
  }

  public static DivideTwoIntegersInterface getSolution() {
    return new DivideTwoIntegersSolutionV1();
  }

  public static class DivideTwoIntegersSolutionV1 implements DivideTwoIntegersInterface {

    @Override
    public int divide(int dividend, int divisor) {
      if (dividend == Integer.MIN_VALUE && divisor == -1) {
        return Integer.MAX_VALUE;
      }

      boolean isNegative = (dividend < 0) ^ (divisor < 0);

      long absDividend = Math.abs((long) dividend);
      long absDivisor = Math.abs((long) divisor);

      int result = 0;
      while (absDividend >= absDivisor) {
        long temp = absDivisor;
        int multiple = 1;
        while (absDividend >= (temp << 1)) {
          temp <<= 1;
          multiple <<= 1;
        }

        absDividend -= temp;
        result += multiple;
      }

      if (isNegative) {
        result = -result;
      }

      return result;
    }
  }

  public interface DivideTwoIntegersInterface {

    int divide(int dividend, int divisor);
  }
}
