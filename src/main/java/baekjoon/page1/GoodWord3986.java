package baekjoon.page1;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.page1
 * @since : 2022/11/28
 */
public class GoodWord3986 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.next());
    int resultCnt = 0;
    Stack<Character> stack = new Stack<Character>();
    for (int i = 0; i < n; i++) {
      String inputStr = scanner.next();
      char[] chars = inputStr.toCharArray();
      for (int j = 0; j < chars.length; j++) {
        if (stack.isEmpty()) {
          stack.push(chars[j]);
          continue;
        }
        if (!stack.isEmpty()) {
          Character pop = stack.pop();
          if (chars[j] != pop) {
            stack.push(pop);
            stack.push(chars[j]);
          }
        }
      }
      if (stack.isEmpty()) {
        resultCnt++;
      }
      stack.removeAllElements();
    }
    System.out.println(resultCnt);
  }
}
