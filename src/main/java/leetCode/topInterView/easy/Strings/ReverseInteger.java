package leetCode.topInterView.easy.Strings;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.easy.Strings
 * @since : 2023/03/08
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880/
 */
public class ReverseInteger {

  public static void main(String[] args) {
    ReverseIntegerSolution solution = new ReverseIntegerSolution();
    int num = 123;
    solution.reverse(num);
  }
}

class ReverseIntegerSolution {

  public int reverse(int n) {
    int rev = 0;
    while (n != 0) {
      int m = n % 10;
      n = n / 10;
      if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) {
        return 0;
      }
      rev = (rev * 10) + m;
    }
    return 0;
  }
}
