package baekjoon.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.greedy
 * @since : 21.12.23
 */
public class CupRamen1781 {

  static class Req {
    public final int ramyeon;
    public final int deadLine;
    public Req(int deadLine, int ramyeon) {
      this.ramyeon = ramyeon;
      this.deadLine = deadLine;
    }
  }

  public static void main(String[] args) {
    Solution solution = new SolutionV1();
    solution.doMain();
  }

  static class SolutionV1 implements Solution {

    @Override
    public void doMain() {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      Req[] req = new Req[n];
      for (int i = 0; i < n; i++) {
        req[i] = new Req(sc.nextInt(), sc.nextInt());
      }
      Arrays.sort(req, Comparator.comparingInt(r -> r.deadLine));
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      int result = 0;
      for (Req r : req) {
        pq.add(r.ramyeon);
        if (pq.size() > r.deadLine) {
          pq.poll();
        }
      }
      while (!pq.isEmpty()) {
        result += pq.poll();
      }
      System.out.println(result);
    }
  }

  interface Solution {

    void doMain();
  }
}
