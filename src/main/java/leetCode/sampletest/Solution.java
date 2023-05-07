package leetCode.sampletest;

import java.util.Stack;

class start {

  public static void main(String[] args) {
    Solution solution = new Solution();
//    String sample = "CBAABD";
    String sample = "ACBDACBD";
    System.out.println(solution.solution(sample));
  }
}

public class Solution {
  public String solution(String S) {
    Stack<Character> stack = new Stack<>();
    for (int i = S.length() - 1; i >= 0; i--) {
      char ch = S.charAt(i);
      if (isPOP(stack, ch)) {
        stack.pop();
      } else {
        stack.push(ch);
      }
    }
    return makeResult(stack);
  }

  private String makeResult(Stack<Character> stack) {
    StringBuilder sb = new StringBuilder();
    while (!stack.empty()) {
      sb.append(stack.pop());  // 스택에서 역순으로 문자열 추출
    }
    return sb.toString();
  }

  private boolean isPOP(Stack<Character> stack, char ch) {
    return !stack.empty()
        && ((ch == 'B' && stack.peek() == 'A') ||
        (ch == 'A' && stack.peek() == 'B') ||
        (ch == 'D' && stack.peek() == 'C') ||
        (ch == 'C' && stack.peek() == 'D')
    );
  }
}

