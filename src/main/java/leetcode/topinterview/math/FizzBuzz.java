package leetcode.topinterview.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Math
 * @since : 2023/05/01
 */
public class FizzBuzz {
  public static class FizzBuzzSolution implements FizzBuzzInterface {
    @Override
    public List<String> fizzBuzz(int n) {
      ArrayList<String> results = new ArrayList<>();
      for (int i = 1; i <= n; i++) {
        if (i < 3) {
          results.add(String.valueOf(i));
        } else if (i % 3 == 0 && i % 5 == 0) {
          results.add("FizzBuzz");
        } else if (i % 3 == 0) {
          results.add("Fizz");
        } else if (i % 5 == 0) {
          results.add("Buzz");
        } else {
          results.add(String.valueOf(i));
        }
      }
      return results;
    }
  }

  public interface FizzBuzzInterface {
    List<String> fizzBuzz(int n);
  }
}

