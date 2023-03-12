package leetCode.topInterView.easy.Strings;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.easy.Strings
 * @since : 2023/03/10
 */
public class StringtoIntegerSolutionTest {

  @Test
  public void finalTestCase1() {
    StringtoIntegerSolution solution = new StringtoIntegerSolution();
    assertEquals(0, solution.myAtoi("words and 987"));
  }

  @Test
  public void finalTestCase2() {
    StringtoIntegerSolution solution = new StringtoIntegerSolution();
    assertEquals(42, solution.myAtoi("42"));
  }

  @Test
  public void finalTestCase3() {
    StringtoIntegerSolution solution = new StringtoIntegerSolution();
    assertEquals(4193, solution.myAtoi("4193 with words"));
  }

  @Test
  public void finalTestCase4() {
    StringtoIntegerSolution solution = new StringtoIntegerSolution();
    assertEquals(-2147483648, solution.myAtoi("-91283472332"));
  }

  @Test
  public void finalTestCase5() {
    StringtoIntegerSolution solution = new StringtoIntegerSolution();
    assertEquals(3, solution.myAtoi("3.14159"));
  }

  @Test
  public void finalTestCase6() {
    StringtoIntegerSolution solution = new StringtoIntegerSolution();
    assertEquals(0, solution.myAtoi("+-12"));
  }

}