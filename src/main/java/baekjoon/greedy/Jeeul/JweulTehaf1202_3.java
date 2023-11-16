package baekjoon.greedy.Jeeul;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.greedy
 * @since : 15.11.23
 */
public class JweulTehaf1202_3 {

  static class Jewel implements Comparable<Jewel> {

    int weight;
    int price;

    public Jewel(int weight, int price) {
      this.weight = weight;
      this.price = price;
    }

    @Override
    public int compareTo(Jewel other) {
      return Integer.compare(other.price, this.price); // 내림차순 정렬
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt(); // 보석의 개수
    int K = scanner.nextInt(); // 가방의 개수

    ArrayList<Jewel> jewels = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      int weight = scanner.nextInt();
      int price = scanner.nextInt();
      jewels.add(new Jewel(weight, price));
    }

    ArrayList<Integer> bags = new ArrayList<>();
    for (int i = 0; i < K; i++) {
      bags.add(scanner.nextInt());
    }

    // 가방과 보석을 무게 기준으로 정렬
    Collections.sort(jewels, (j1, j2) -> Integer.compare(j1.weight, j2.weight));
    Collections.sort(bags);

    long totalValue = 0;
    int jewelIndex = 0;
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    // 가방에 넣을 수 있는 보석 중 최대 가치의 보석을 선택
    for (int bagCapacity : bags) {
      while (jewelIndex < N
          && jewels.get(jewelIndex).weight <= bagCapacity) {
        maxHeap.offer(jewels.get(jewelIndex).price);
        jewelIndex++;
      }

      if (!maxHeap.isEmpty()) {
        totalValue += maxHeap.poll();
      }
    }

    System.out.println(totalValue);
  }
}
