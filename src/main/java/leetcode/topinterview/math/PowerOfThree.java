package leetcode.topinterview.math;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Math
 * @since : 2023/05/10
 */
public class PowerOfThree {

  public static void main(String[] args) {
    PowerOfThreeInterface solution = getSolution();
    System.out.println(solution.isPowerOfThree(1162261467));
    System.out.println(solution.isPowerOfThree(28));
    System.out.println(solution.isPowerOfThree(27));
    System.out.println(solution.isPowerOfThree(2));
  }

  private static PowerOfThreeInterface getSolution() {
    return new PowerOfThreeSolution();
  }

  public static class PowerOfThreeSolution implements PowerOfThreeInterface {

    @Override
    public boolean isPowerOfThree(int n) {
      if (n <= 0) {
        return false;
      } else if (n == 1) {
        return true;
      } else if (n % 3 != 0) { // n이 3의
        return false;
      } else {
        return isPowerOfThree(n / 3);
      }
    }
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

  public interface PowerOfThreeInterface {

    boolean isPowerOfThree(int n);
  }
}
