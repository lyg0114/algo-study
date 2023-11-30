package baekjoon.greedy;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.greedy
 * @url : https://www.acmicpc.net/problem/9935
 * @since : 29.11.23
 */
public class StringExplosion9935 {

  public static void main(String[] args) {
    Solution solution = getSolution();
    solution.doMain();
  }

  private static Solution getSolution() {
    return new SolutionV1_TimeAtacck();
  }

  static class SolutionV1_TimeAtacck implements Solution {
    static class TargetIndex {
      int start;
      int removeCnt;
      public TargetIndex(int start, int removeCnt) {
        this.start = start;
        this.removeCnt = removeCnt;
      }
      public int getStart() { return start;}
      public int getRemoveCnt() { return removeCnt; }
    }

    static int successCount = 0;
    public void doMain(){
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
      if(result.isEmpty())
        result = "FRULA";
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
    void doMain();
  }
}
