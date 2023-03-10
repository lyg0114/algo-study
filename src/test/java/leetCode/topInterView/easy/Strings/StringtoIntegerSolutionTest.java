package leetCode.topInterView.easy.Strings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.easy.Strings
 * @since : 2023/03/10
 */
public class StringtoIntegerSolutionTest {

  @Test
  public void testFirstDigit() {
    StringtoIntegerSolution solution = new StringtoIntegerSolution();
    solution.myAtoi("123");
    assertEquals(0, solution.getIndexOfFirstDigit());

    StringtoIntegerSolution solution2 = new StringtoIntegerSolution();
    solution.myAtoi(" 123");
    assertEquals(0, solution.getIndexOfFirstDigit());

    StringtoIntegerSolution solution3 = new StringtoIntegerSolution();
    solution.myAtoi("+123");
    assertEquals(0, solution.getIndexOfFirstDigit());

  }

  @Test
  public void testFirstDigit2() {
    StringtoIntegerSolution solution = new StringtoIntegerSolution();
    solution.myAtoi("-00123");
    assertEquals(3, solution.getIndexOfFirstDigit());
    assertTrue(solution.isNegative());

    StringtoIntegerSolution solution2 = new StringtoIntegerSolution();
    solution2.myAtoi("+00123");
    assertEquals(3, solution2.getIndexOfFirstDigit());
    assertFalse(solution2.isNegative());
  }

}