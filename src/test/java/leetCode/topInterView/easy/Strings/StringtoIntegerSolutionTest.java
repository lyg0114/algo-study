package leetCode.topInterView.easy.Strings;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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

  @Test
  public void testLetters() {
//    StringtoIntegerSolution solution = new StringtoIntegerSolution();
//    solution.myAtoi("A123");
//    assertEquals(1, solution.getIndexOfFirstDigit());
//    assertFalse(solution.isNegative());
//

//    StringtoIntegerSolution solutio2 = new StringtoIntegerSolution();
//    solutio2.myAtoi("-A1asdf23");
//    assertEquals(2, solutio2.getIndexOfFirstDigit());
//    assertTrue(solutio2.isNegative());
//    System.out.println(solutio2.getResultChars());

    StringtoIntegerSolution solutio2 = new StringtoIntegerSolution();
    solutio2.myAtoi("4193 with words");
    assertEquals(0, solutio2.getIndexOfFirstDigit());
    assertFalse(solutio2.isNegative());
    System.out.println(solutio2.getResultChars());
  }

}