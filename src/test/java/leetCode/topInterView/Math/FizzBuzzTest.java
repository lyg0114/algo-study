package leetCode.topInterView.Math;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Math
 * @since : 2023/05/01
 */
public class FizzBuzzTest {

  private FizzBuzzInterface getFizzBuzzSolution() {
    return new FizzBuzzSolution();
  }

  @Test
  public void test_when_n_equals_3() {
    FizzBuzzInterface solution = getFizzBuzzSolution();
    List<String> results = solution.fizzBuzz(3);

    String[] arr = {"1", "2", "Fizz"};
    List<String> match = Arrays.asList(arr);

    for (int i = 0; i < match.size(); i++) {
      Assert.assertEquals(results.get(i), match.get(i));
    }
  }

  @Test
  public void test_when_n_equals_15() {
    FizzBuzzInterface solution = getFizzBuzzSolution();
    List<String> results = solution.fizzBuzz(15);
    String[] arr = {"1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"};
    List<String> match = Arrays.asList(arr);

    for (int i = 0; i < match.size(); i++) {
      Assert.assertEquals(results.get(i), match.get(i));
    }
  }
}