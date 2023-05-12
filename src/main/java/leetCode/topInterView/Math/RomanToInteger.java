package leetCode.topInterView.Math;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Math
 * @url : https://leetcode.com/explore/featured/card/top-interview-questions-easy/102/math/878/
 * @since : 2023/05/12
 */
public class RomanToInteger {

  public static void main(String[] args) {
    RomanToIntegerInterface solution = getSolution();
    System.out.println(solution.romanToInt("X"));
  }

  static class RomanToIntegerSolution implements RomanToIntegerInterface {

    public int romanToInt(String s) {
      return 0;
    }
  }

  private static RomanToIntegerSolution getSolution() {
    return new RomanToIntegerSolution();
  }

  interface RomanToIntegerInterface {

    int romanToInt(String s);
  }
}
