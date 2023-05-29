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
  public void test_n_equal_3_GenerateParentheses() {
    GenerateParenthesesInterface solution = GenerateParentheses.getSolution();
    int n = 3;
    List<String> actuals = solution.generateParenthesis(n);
    List<String> expacts = Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()");
    for (String actual : actuals) {
      assertTrue(expacts.contains(actual));
    }
  }

  @Test
  public void test_n_equal_4_GenerateParentheses() {
    GenerateParenthesesInterface solution = GenerateParentheses.getSolution();
    int n = 5;
    List<String> actuals = solution.generateParenthesis(n);
    for (String actual : actuals) {
      System.out.println("actual = " + actual);
    }
  }

  @Test
  public void test_n_equal_6_GenerateParentheses() {
    GenerateParenthesesInterface solution = GenerateParentheses.getSolution();
    int n = 6;
    List<String> actuals = solution.generateParenthesis(n);
    for (String actual : actuals) {
      System.out.println("actual = " + actual);
    }
  }
}