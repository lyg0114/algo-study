package leetcode.topinterview.math;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Math
 * @since : 06.11.23
 */
public class SqrtX {

  public static void main(String[] args) {
    SqrtXInterface solution = getSolution();
    int input = 123;
    int result = solution.mySqrt(input);
    System.out.println("result = " + result);
  }

  public static SqrtXInterface getSolution() {
    return new SqrtXSolution();
  }

  private static class SqrtXSolution implements SqrtXInterface {

    @Override
    public int mySqrt(int x) {
      if (x == 0 || x == 1) {
        return x;
      }

      int start = 1;
      int end = x;
      int mid = -1;

      while (start <= end) {
        mid = start + (end - start) / 2;
        if ((long) mid * mid > (long) x)
          end = mid - 1;
        else if (mid * mid == x)
          return mid;
        else
          start = mid + 1;
      }
      System.out.println("end = " + end);
      return Math.round(end);
    }
  }

  public interface SqrtXInterface {

    int mySqrt(int x);
  }
}
