package leetcode.topinterview.math;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Math
 * @url : https://leetcode.com/explore/featured/card/top-interview-questions-easy/102/math/878/
 * @since : 2023/05/12
 */
public class RomanToInteger {

  public static void main(String[] args) {
    RomanToIntegerInterface solution = getSolution();
    System.out.println(solution.romanToInt("MCMXCIV"));
//    System.out.println(solution.romanToInt("LVIII"));
//    System.out.println(solution.romanToInt("III"));
  }

  private static RomanToIntegerInterface getSolution() {
    return new RomanToIntegerSolution1();
  }

  static class RomanToIntegerSolution1 implements RomanToIntegerInterface {

    private final Map<Character, Integer> romanMap = new HashMap<Character, Integer>() {{
      put('I', 1);
      put('V', 5);
      put('X', 10);
      put('L', 50);
      put('C', 100);
      put('D', 500);
      put('M', 1000);
    }};

    public int romanToInt(String s) {
      int result = 0;
      int prev = 0;

      for (int i = s.length() - 1; i >= 0; i--) {
        int current = romanMap.get(s.charAt(i));
        if (current < prev) {
          result -= current;
        } else {
          result += current;
        }
        prev = current;
      }

      return result;
    }

  }

  static class RomanToIntegerSolution2 implements RomanToIntegerInterface {

    int result = 0;

    public int romanToInt(String s) {
      int result = 0;

      if (s.contains("IV")) {
        result += 4;
        s = s.replace("IV", "");
      }

      if (s.contains("IX")) {
        result += 9;
        s = s.replace("IX", "");
      }

      if (s.contains("XL")) {
        result += 40;
        s = s.replace("XL", "");
      }

      if (s.contains("XC")) {
        result += 90;
        s = s.replace("XC", "");
      }

      if (s.contains("CD")) {
        result += 400;
        s = s.replace("CD", "");
      }

      if (s.contains("CM")) {
        result += 900;
        s = s.replace("CM", "");
      }

      System.out.println(s);
      char[] chars = s.toCharArray();

      if (s.contains("I")) {
        result = getResult(result, chars, 'I', 1);
        s = s.replace("I", "");
      }

      if (s.contains("V")) {
        result = getResult(result, chars, 'V', 5);
        s = s.replace("V", "");
      }

      if (s.contains("X")) {
        result = getResult(result, chars, 'X', 10);
        s = s.replace("X", "");
      }

      if (s.contains("L")) {
        result = getResult(result, chars, 'L', 50);
        s = s.replace("L", "");
      }

      if (s.contains("C")) {
        result = getResult(result, chars, 'C', 100);
        s = s.replace("C", "");
      }

      if (s.contains("D")) {
        result = getResult(result, chars, 'D', 500);
        s = s.replace("D", "");
      }

      if (s.contains("M")) {
        result = getResult(result, chars, 'M', 1000);
        s = s.replace("M", "");
      }

      return result;
    }


    private int getResult(int result, char[] chars, char target, int add) {
      for (int i = 0; i < chars.length; i++) {
        if (chars[i] == target) {
          result += add;
          chars[i] = '@';
        }
      }
      return result;
    }
  }

  interface RomanToIntegerInterface {

    int romanToInt(String s);
  }
}
