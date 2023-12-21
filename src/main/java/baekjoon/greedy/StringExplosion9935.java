package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.greedy
 * @url : https://www.acmicpc.net/problem/9935
 * @since : 29.11.23
 */
public class StringExplosion9935 {

  public static void main(String[] args) throws IOException {
    Solution solution = new SolutionStackV4();
    solution.doMain();
  }

  static class SolutionStackV4 implements Solution {

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

  static class SolutionV2 implements Solution {

    @Override
    public void doMain() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String inputString = br.readLine();
      String explosionString = br.readLine();

      while (inputString.contains(explosionString)) {
        inputString = inputString.replace(explosionString, "");
      }

      if (inputString.isEmpty()) {
        System.out.println("FRULA");
      } else {
        System.out.println(inputString);
      }
    }

  }

  static class SolutionV1 implements Solution {

    static class TargetIndex {

      int start;
      int removeCnt;

      public TargetIndex(int start, int removeCnt) {
        this.start = start;
        this.removeCnt = removeCnt;
      }

      public int getStart() {
        return start;
      }

      public int getRemoveCnt() {
        return removeCnt;
      }
    }

    static int successCount = 0;

    public void doMain() {
      Scanner sc = new Scanner(System.in);
      String targetStr = sc.next();
      String bomb = sc.next();
      char[] charArray = targetStr.toCharArray();
      char[] bombArray = bomb.toCharArray();
      List<Character> charList = new LinkedList<>();
      for (char c : charArray) {
        charList.add(c);
      }

      while (true) {
        for (int i = 0; i < charList.size(); i++) {
          if (charList.get(i).equals(bombArray[0])) {
            TargetIndex target = checkTheTarget(i, charList, bombArray);
            if (target != null) {
              bombCharList(charList, i, target);
            }
          }
        }
        if (successCount == 0) {
          break;
        } else {
          successCount = 0;
        }
      }
      String result = charList.stream()
          .map(String::valueOf)
          .collect(Collectors.joining());
      if (result.isEmpty()) {
        result = "FRULA";
      }
      System.out.println(result);

    }

    private void bombCharList(
        List<Character> charList, int index, TargetIndex target
    ) {
      for (int i = 0; i < target.getRemoveCnt(); i++) {
        charList.remove(index);
      }
      successCount += 1;
    }

    private TargetIndex checkTheTarget(
        int idx, List<Character> charList, char[] bombArray
    ) {
      for (int i = 0; i < bombArray.length; i++) {
        if (!(charList.get(idx + i).equals(bombArray[i]))) {
          return null;
        }
      }
      return new TargetIndex(idx, bombArray.length);
    }
  }

  interface Solution {

    void doMain() throws IOException;
  }

}
