package codility.v1;

import java.util.Stack;

/**
 * @author : iyeong-gyo
 * @package : codility
 * @since : 11.11.23
 */
public class CodilitySolution2 {

  public static void main(String[] args) {
    Solution solution = new Solution();
    String input = "CBACD";
    String result = solution.solution(input);
    System.out.println("result = " + result);
  }

  static class Solution {
    public String solution(String input) {
      if (input.isEmpty()) {
        return "";
      }
      char[] chs = input.toCharArray();
      Stack<Character> chStack = new Stack<>();
      for (char ch : chs) {
        if (chStack.isEmpty()) {
          chStack.push(ch);
        } else {
          Character peek = chStack.peek();
          if (validation(peek, ch)) {
            chStack.pop();
          } else {
            chStack.push(ch);
          }
        }
      }
      return stackToString(chStack);
    }

    private boolean validation(Character peek, char ch) {
      if (peek.equals('A') && ch == 'B')return true;
      if (peek.equals('B') && ch == 'A')return true;
      if (peek.equals('C') && ch == 'D')return true;
      if (peek.equals('D') && ch == 'C')return true;
      return false;
    }

    private static String stackToString(Stack<Character> stack) {
      StringBuilder sb = new StringBuilder();
      while (!stack.isEmpty()) {
        sb.append(stack.pop());
      }
      return sb.reverse().toString();
    }
  }
}
