package leetCode.topInterView.others;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.others
 * @since : 2023/05/30
 */
public class DivideTwoIntegers {

  public static void main(String[] args) {
    DivideTwoIntegersInterface solution = getSolution();
  }

  public static DivideTwoIntegersInterface getSolution() {
    return new DivideTwoIntegersSolutionV1();
  }

  public static class DivideTwoIntegersSolutionV1 implements DivideTwoIntegersInterface {

    @Override
    public int divide(int dividend, int divisor) {
      return 0;
    }
  }


  public interface DivideTwoIntegersInterface {

    int divide(int dividend, int divisor);
  }

}
