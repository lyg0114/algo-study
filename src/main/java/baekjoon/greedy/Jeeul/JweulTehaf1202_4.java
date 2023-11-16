package baekjoon.greedy.Jeeul;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.greedy
 * @since : 15.11.23
 */
public class JweulTehaf1202_4 {

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
    jewels.sort(Comparator.comparingInt(j -> j.weight));
    Collections.sort(bags);

    int totalValue = 0;
    int jewelIndex = 0;
    PriorityQueue<Integer> maxPrice = new PriorityQueue<>(Collections.reverseOrder());

    for (Integer bagCapacity : bags) {
      while (jewelIndex < N && jewels.get(jewelIndex).weight <= bagCapacity) {
        maxPrice.offer(jewels.get(jewelIndex).price);
        jewelIndex++;
      }

      if (!maxPrice.isEmpty()) {
        totalValue += maxPrice.poll();
      }
    }

    System.out.println("totalValue = " + totalValue);
  }
}
