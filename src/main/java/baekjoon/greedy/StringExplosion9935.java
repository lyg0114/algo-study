package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.greedy
 * @url : https://www.acmicpc.net/problem/9935
 * @since : 29.11.23
 */
public class StringExplosion9935 {

  public static void main(String[] args) throws IOException {
    Solution solution = new SolutionUsingStack();
    solution.doMain();
  }

  static class SolutionUsingStack implements Solution {

    @Override
    public void doMain() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String str = br.readLine();
      String boom = br.readLine();
      Stack<Character> stack = new Stack();
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < str.length(); i++) {
        stack.push(str.charAt(i));
        if (stack.size() >= boom.length()
            && stack.peek().equals(boom.charAt(boom.length() - 1))) {
          for (int j = 0; j < boom.length(); j++) {
            Character pop = stack.pop();
            sb.append(pop);
          }
          String popStr = sb.reverse().toString();
          sb.setLength(0);
          if (!popStr.equals(boom)) {
            for (int j = popStr.length() - 1; j > -1; j--) {
              stack.push(popStr.charAt(i));
            }
          }
        }
      }
      if (!stack.isEmpty()) {
        sb.setLength(0);
        for (Character c : stack) {
          sb.append(c);
        }
        System.out.println(sb);
      } else {
        System.out.println("FRULA");
      }
    }
  }

  static class SolutionV3 implements Solution {

    @Override
    public void doMain() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String str = br.readLine();
      String boom = br.readLine();
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);
        sb.append(ch);
        if (sb.length() >= boom.length()) {
          boolean sameFlag = true;
          for (int j = 0; j < boom.length(); j++) {
            char ch1 = sb.charAt(sb.length() - boom.length() + j);
            char ch2 = boom.charAt(j);
            if (ch1 != ch2) {
              sameFlag = false;
              break;
            }
          }
          if (sameFlag) {
            sb.delete(sb.length() - boom.length(), sb.length());
          }
        }
      }
      if (sb.length() == 0) {
        System.out.println("FRULA");
      } else {
        System.out.println(sb.toString());
      }
    }
  }

  static class SolutionRecover implements Solution {

    @Override
    public void doMain() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String str = br.readLine();
      String boom = br.readLine();

      StringBuilder sb = new StringBuilder();
      boolean isSame;

      for (int i = 0; i < str.length(); i++) {
        sb.append(str.charAt(i));
        isSame = true;
        if (sb.length() >= boom.length()) {
          for (int j = 0; j < boom.length(); j++) {
            char ch = sb.charAt(sb.length() - boom.length() + j);
            char bCh = boom.charAt(j);
            if (ch != bCh) {
              isSame = false;
            }
          }
          if (isSame) {
            sb.delete(sb.length() - boom.length(), sb.length());
          }
        }
      }

      if (sb.length() > 0) {
        System.out.println(sb);
      } else {
        System.out.println("FRULA");
      }
    }
  }

  interface Solution {

    void doMain() throws IOException;
  }
}
