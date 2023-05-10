package leetCode.topInterView.Math;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Math
 * @since : 2023/05/10
 */
public class PowerOfThree {

  public static void main(String[] args) {
    PowerOfThreeSolution solution = new PowerOfThreeSolution();
    boolean powerOfThree = solution.isPowerOfThree(28);
    System.out.println("powerOfThree = " + powerOfThree);
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
