package baekjoon.page5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.greedy
 * @since : 23.12.23
 */
public class Question14469 {

  public static void main(String[] args) throws IOException {
    Solution solution = new SolutionV2();
    solution.doMain();
  }

  static class SolutionV2 implements Solution {

    static class ArriveGoat {
      private final int arrTime;
      private final int checkTime;

      public ArriveGoat(int arrTime, int checkTime) {
        this.arrTime = arrTime;
        this.checkTime = checkTime;
      }
      public int getArrTime() { return arrTime; }
    }

    @Override
    public void doMain() throws IOException {
      Scanner sc = new Scanner(System.in);
      int totalCnt = sc.nextInt();
      List<ArriveGoat> goats = new ArrayList<>();
      for (int i = 0; i < totalCnt; i++) {
        goats.add(new ArriveGoat(sc.nextInt(), sc.nextInt()));
      }
      goats.sort(Comparator.comparingInt(ArriveGoat::getArrTime));
      int realTime = goats.get(0).arrTime + goats.get(0).checkTime;
      for (int i = 1; i < goats.size(); i++) {
        realTime = Math.max(realTime, goats.get(i).getArrTime());
        realTime += goats.get(i).checkTime;
      }
      System.out.println(realTime);
    }
  }

  static class SolutionV1 implements Solution {

    static class ArriveGoat {
      private int arrTime;
      private final int checkTime;

      public ArriveGoat(int arrTime, int checkTime) {
        this.arrTime = arrTime;
        this.checkTime = checkTime;
      }
      public int getArrTime() { return arrTime; }
      public int getTerm(){return arrTime + checkTime;}
      public void setArrTime(int arrTime) {
        this.arrTime = arrTime;
      }
    }

    @Override
    public void doMain() throws IOException {
      Scanner sc = new Scanner(System.in);
      int totalCnt = sc.nextInt();
      List<ArriveGoat> goats = new ArrayList<>();
      for (int i = 0; i < totalCnt; i++) {
        goats.add(new ArriveGoat(sc.nextInt(), sc.nextInt()));
      }
      goats.sort(Comparator.comparingInt(ArriveGoat::getArrTime));
      Stack<ArriveGoat> stack = new Stack<>();
      int totalTime = 0;

      totalTime = goats.get(0).getTerm();
      stack.push(goats.get(0));
      for (int i = 1; i < goats.size(); i++) {
        ArriveGoat peek = stack.peek();
        if (peek.getTerm() <= goats.get(i).getArrTime()) {
          stack.pop();
          totalTime = goats.get(i).getTerm();
          stack.push(goats.get(i));
        } else {
          goats.get(i).setArrTime(totalTime);
          totalTime = goats.get(i).getTerm();
          stack.pop();
          stack.push(goats.get(i));
        }
      }
      System.out.println(totalTime);
    }
  }

  interface Solution {

    void doMain() throws IOException;
  }
}
