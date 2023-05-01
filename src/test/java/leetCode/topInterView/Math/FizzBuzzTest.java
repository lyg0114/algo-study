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
  public void testCase1() {
    FizzBuzzInterface solution = getFizzBuzzSolution();
    List<String> results = solution.fizzBuzz(3);

    String[] arr = {"1", "2", "Fizz"};
    List<String> match = Arrays.asList(arr);

    for (int i = 0; i < match.size(); i++) {
      Assert.assertEquals(results.get(i), match.get(i));
    }
  }

}