package baekjoon.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.greedy
 * @url : https://www.acmicpc.net/problem/14729
 * @since : 16.11.23
 */
public class ChilMuHae14729 {

  public static void main(String[] args) {
    SolutionINterface solution = getSolution();
    solution.solution();
  }

  private static SolutionINterface getSolution() {
    return new SolutionV3();
  }

  static class SolutionV3 implements SolutionINterface {

    @Override
    public void solution() {
      Scanner scanner = new Scanner(System.in);
      int N = scanner.nextInt();
      PriorityQueue<Double> minScore = new PriorityQueue<>(Comparator.reverseOrder());
      int i = 0;
      while (i < N) {
        double v = scanner.nextDouble();
        if (minScore.size() == 7) {
          minScore.offer(v);
          minScore.poll();
        }
        minScore.offer(v);
        i++;
      }

      List<Double> results = new ArrayList<>(minScore);
      Collections.sort(results);
      for (Double score : results) {
        System.out.printf("%.3f", score);
        System.out.println();
      }
    }
  }

  static class SolutionV2 implements SolutionINterface {

    @Override
    public void solution() {
      Scanner scanner = new Scanner(System.in);
      int N = scanner.nextInt();
      PriorityQueue<Double> minScore = new PriorityQueue<>();
      int i = 0;
      while (i < N) {
        double v = scanner.nextDouble();
        minScore.offer(v);
        i++;
      }
      for (int j = 0; j < 7; j++) {
        Double score = minScore.poll();
        System.out.printf("%.3f", score);
        System.out.println();
      }
    }
  }

  static class SolutionV1 implements SolutionINterface {

    @Override
    public void solution() {
      Scanner scanner = new Scanner(System.in);
      int N = scanner.nextInt();
      Map<Double, Integer> map = new HashMap<>();
      int i = 0;
      while (i < N) {
        double v = scanner.nextDouble();
        map.merge(v, 1, Integer::sum);
        i++;
      }

      PriorityQueue<Double> minScore = new PriorityQueue<>();
      for (Double v : map.keySet()) {
        minScore.offer(v);
      }
      int chk = 0;
      while (!minScore.isEmpty()) {
        Double score = minScore.poll();
        Integer rotate = map.get(score);
        for (int k = 0; k < rotate; k++) {
          System.out.printf("%.3f", score);
          System.out.println();
          chk++;
          if (chk == 7) {
            break;
          }
        }
      }
    }
  }

  interface SolutionINterface {

    void solution();
  }
}
