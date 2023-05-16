package leetCode.topInterView.others;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.others
 * @since : 2023/05/16
 */
public class ValidParentheses {

  public static void main(String[] args) {
    String s = "([{}])";
    ValidParenthesesInterface solution = getSolution();
    System.out.println(solution.isValid(s));
  }

  private static ValidParenthesesInterface getSolution() {
    return new ValidParenthesesSolution();
  }

  public static class ValidParenthesesSolution implements ValidParenthesesInterface {

    @Override
    public boolean isValid(String s) {
      HashMap<Character, Character> map = new HashMap<>();
      map.put('(', ')');
      map.put('[', ']');
      map.put('{', '}');
      Stack<Character> stack = new Stack<>();
      for (int i = 0; i < s.length(); i++) {
        if (stack.isEmpty()) {
          if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
            return false;
          }
          stack.push(s.charAt(i));
        } else {
          Character peek = stack.peek();
          Character pairChr = map.get(peek);
          if (pairChr != null && s.charAt(i) == pairChr) {
            stack.pop();
          } else {
            stack.push(s.charAt(i));
          }
        }
      }
      return stack.isEmpty();
    }
  }

  interface ValidParenthesesInterface {

    boolean isValid(String s);
  }
}
