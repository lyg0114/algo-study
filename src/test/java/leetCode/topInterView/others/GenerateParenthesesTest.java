package leetCode.topInterView.others;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import leetCode.topInterView.others.GenerateParentheses.GenerateParenthesesInterface;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.others
 * @since : 2023/05/29
 */
public class GenerateParenthesesTest {

  @Test
  public void test_GenerateParentheses() {
    GenerateParenthesesInterface solution = GenerateParentheses.getSolution();
    int n = 3;
    List<String> actuals = solution.generateParenthesis(3);
    List<String> expacts = Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()");
    assertEquals(expacts, actuals);
  }
}