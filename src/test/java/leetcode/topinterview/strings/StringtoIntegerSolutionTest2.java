package leetcode.topinterview.strings;

import static org.junit.Assert.assertEquals;

import leetcode.topinterview.strings.atoI.StringtoIntegerSolution;
import leetcode.topinterview.strings.atoI.StringtoIntegerSolution2;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Strings
 * @since : 2023/03/10
 */
public class StringtoIntegerSolutionTest2 {

  @Test
  public void finalTestCase1() {
    StringtoIntegerSolution solution = new StringtoIntegerSolution2();
    assertEquals(0, solution.myAtoi("words and 987"));
  }

  @Test
  public void finalTestCase2() {
    StringtoIntegerSolution solution = new StringtoIntegerSolution2();
    assertEquals(42, solution.myAtoi("42"));
  }

  @Test
  public void finalTestCase3() {
    StringtoIntegerSolution solution = new StringtoIntegerSolution2();
    assertEquals(4193, solution.myAtoi("4193 with words"));
  }

  @Test
  public void finalTestCase4() {
    StringtoIntegerSolution solution = new StringtoIntegerSolution2();
    assertEquals(-2147483648, solution.myAtoi("-91283472332"));
  }

  @Test
  public void finalTestCase5() {
    StringtoIntegerSolution solution = new StringtoIntegerSolution2();
    assertEquals(3, solution.myAtoi("3.14159"));
  }

  @Test
  public void finalTestCase6() {
    StringtoIntegerSolution solution = new StringtoIntegerSolution2();
    assertEquals(0, solution.myAtoi("+-12"));
  }

  @Test
  public void finalTestCase7() {
    StringtoIntegerSolution solution = new StringtoIntegerSolution2();
    assertEquals(0, solution.myAtoi("00000-42a1234"));
  }

  @Test
  public void finalTestCase8() {
    StringtoIntegerSolution solution = new StringtoIntegerSolution2();
    assertEquals(0, solution.myAtoi(""));
  }

  @Test
  public void finalTestCase9() {
    StringtoIntegerSolution solution = new StringtoIntegerSolution2();
    assertEquals(2147483647, solution.myAtoi("2147483648"));
  }

  @Test
  public void finalTestCase10() {
    StringtoIntegerSolution solution = new StringtoIntegerSolution2();
    assertEquals(2147483646, solution.myAtoi("2147483646"));
  }

  @Test
  public void finalTestCase11() {
    StringtoIntegerSolution solution = new StringtoIntegerSolution2();
    assertEquals(7, solution.myAtoi("7"));
  }

  @Test
  public void finalTestCase12() {
    StringtoIntegerSolution solution = new StringtoIntegerSolution2();
    assertEquals(-2147483648, solution.myAtoi("-2147483648"));
  }

  @Test
  public void finalTestCase13() {
    StringtoIntegerSolution solution = new StringtoIntegerSolution2();
    assertEquals(-1147483648, solution.myAtoi("-1147483648"));
  }

  @Test
  public void finalTestCase14() {
    StringtoIntegerSolution solution = new StringtoIntegerSolution2();
    assertEquals(2147483647, solution.myAtoi("21474836460"));
  }

  @Test
  public void finalTestCase15() {
    StringtoIntegerSolution solution = new StringtoIntegerSolution2();
    assertEquals(-1, solution.myAtoi("-1"));
  }

  @Test
  public void finalTestCase16() {
    StringtoIntegerSolution solution = new StringtoIntegerSolution2();
    assertEquals(-2147483648, solution.myAtoi("-21474836482"));
  }
}