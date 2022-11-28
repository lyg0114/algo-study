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

    Stack<String> stack = new Stack<String>();
    for (int i = 0; i < n; i++) {
      String str = scanner.next();
      if(stack.isEmpty()){
        stack.push(str);
        continue;
      }
      if(!stack.isEmpty()){
        String pop = stack.pop();
        if(!str.equals(pop)){
          stack.push(pop);
          stack.push(str);
        }
      }
    }

    if(stack.isEmpty()){
      System.out.println("good word");
    }
  }
}
