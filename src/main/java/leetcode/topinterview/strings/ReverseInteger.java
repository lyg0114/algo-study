package leetcode.topinterview.strings;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Strings
 * @since : 2023/03/08 https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880/
 */
public class ReverseInteger {

  public static void main(String[] args) {
    ReverseIntegerInterface solution = getSolution();
    int num = 123;
    int reverse = solution.reverse(num);
    System.out.println("reverse = " + reverse);
  }

  public static ReverseIntegerInterface getSolution() {
    return new ReverseIntegerSolution();
  }

  public static class ReverseIntegerSolution implements ReverseIntegerInterface {

    public int reverse(int x) {
      int rev = 0;
      while (x != 0) {
        int m = x % 10;
        x = x / 10;
        if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) {
          return 0;
        }
        rev = (rev * 10) + m;
      }
      return rev;
    }
  }

  public interface ReverseIntegerInterface {

    int reverse(int x);
  }
}

