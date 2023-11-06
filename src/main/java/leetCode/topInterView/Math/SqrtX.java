package leetCode.topInterView.Math;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Math
 * @since : 06.11.23
 */
public class SqrtX {

  public static void main(String[] args) {
    SqrtXInterface solution = getSolution();
    int input = 3;
    int result = solution.mySqrt(input);
    System.out.println("result = " + result);
  }

  public static SqrtXInterface getSolution() {
    return new SqrtXSolution();
  }

  private static class SqrtXSolution implements SqrtXInterface {

    @Override
    public int mySqrt(int x) {
      return 0;
    }
  }

  public interface SqrtXInterface {

    int mySqrt(int x);
  }
}
