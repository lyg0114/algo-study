package baekjoon.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.greedy
 * @url : https://www.acmicpc.net/problem/2109
 * @since : 28.11.23
 */
public class LectureTour2109 {
  static class Req {
    private int price;
    private int maxDat;
    public Req(int price, int maxDat) {
      this.price = price;
      this.maxDat = maxDat;
    }
    public int getPrice() { return price; }
    public int getMaxDat() { return maxDat; }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Req[] req = new Req[n];
    for (int i = 0; i < n; i++) {
      req[i] = new Req(sc.nextInt(), sc.nextInt());
    }
    Arrays.sort(req, Comparator.comparingInt(r -> r.maxDat));
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int result = 0;
    for (Req r : req) {
      pq.add(r.getPrice());
      if(pq.size() > r.getMaxDat()){
        pq.poll();
      }
    }
    while(!pq.isEmpty()){
      result += pq.poll();
    }
    System.out.println(result);
  }
}
