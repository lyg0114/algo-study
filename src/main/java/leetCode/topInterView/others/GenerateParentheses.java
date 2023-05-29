package leetCode.topInterView.others;

import java.util.List;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.others
 * @url : https://leetcode.com/problems/generate-parentheses/
 * @since : 2023/05/29
 */
public class GenerateParentheses {

  public static void main(String[] args) {
    GenerateParenthesesInterface solution = getSolution();
  }

  public static GenerateParenthesesInterface getSolution() {
    return new GenerateParenthesesSolutionV1();
  }

  public static class GenerateParenthesesSolutionV1 implements GenerateParenthesesInterface {

    @Override
    public List<String> generateParenthesis(int n) {
      return null;
    }
  }

  public interface GenerateParenthesesInterface {

    List<String> generateParenthesis(int n);
  }
}

