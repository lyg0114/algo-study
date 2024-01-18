package baekjoon.page5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.greedy
 * @since : 26.12.23
 */
public class Question1202 {
  public static void main(String[] args) throws IOException {
    Solution solution = new SolutionImpl();
    solution.doMain();
  }

  static class SolutionImpl implements Solution {
    static class Jewel {
      int weight;
      int price;
      public Jewel(int weight, int price) {
        this.weight = weight;
        this.price = price;
      }
    }

    @Override
    public void doMain() throws IOException {
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      int K = sc.nextInt();
      List<Jewel> jewels = new ArrayList<>();
      List<Integer> bags = new ArrayList<>();
      for (int i = 0; i < N; i++) jewels.add(new Jewel(sc.nextInt(), sc.nextInt()));
      for (int i = 0; i < K; i++) bags.add(sc.nextInt());

      jewels.sort(Comparator.comparingInt(j -> j.weight));
      Collections.sort(bags);

      long total = 0;
      int idx = 0;
      PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
      for (int b : bags) {
        while (idx < N && jewels.get(idx).weight <= b) {
          maxHeap.offer(jewels.get(idx++).price);
        }
        if (!maxHeap.isEmpty()) {
          total += maxHeap.poll();
        }
      }
      System.out.println(total);
    }
  }

  interface Solution {
    void doMain() throws IOException;
  }
}
