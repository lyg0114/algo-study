package leetCode.topInterView.Math;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Math
 * @since : 2023/05/10
 */
public class PowerOfThree {

  public static void main(String[] args) {
    PowerOfThreeInterface solution = getSolution();
    boolean powerOfThree = solution.isPowerOfThree(1162261467);
    System.out.println("powerOfThree = " + powerOfThree);
  }

  private static PowerOfThreeInterface getSolution() {
    return new PowerOfThreeSolution2();
  }

  public static class PowerOfThreeSolution2 implements PowerOfThreeInterface {

    @Override
    public boolean isPowerOfThree(int n) {
      if (n <= 0) {
        return false;
      }

      int target = 1;
      int MAX_VALUE = 1162261467;
      while (target < MAX_VALUE + 1) {
        if (target == n) {
          return true;
        }
        target *= 3;
        System.out.println("target = " + target);
      }
      return false;
    }
  }

  public static class PowerOfThreeSolution implements PowerOfThreeInterface {

    @Override
    public boolean isPowerOfThree(int n) {
      if (n == 0 || n < 0) {
        return false;
      }
      if (n == 1162261467) {
        return true;
      }

      int limit = Integer.MAX_VALUE / 3;
      int start = 1;
      while ((start < n && n < limit)) {
        start *= 3;
      }

      return start == n;
    }
  }


  public interface PowerOfThreeInterface {

    boolean isPowerOfThree(int n);
  }
}
