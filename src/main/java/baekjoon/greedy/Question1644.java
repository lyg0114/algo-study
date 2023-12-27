package baekjoon.greedy;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.greedy
 * @since : 27.12.23
 */
public class Question1644 {

  public static void main(String[] args) throws IOException {
    Solution solution = new SolutionImpl();
    solution.doMain();
  }

  static class SolutionImpl implements Solution {
    private final boolean[] che = new boolean[4000001];
    private final int[] a = new int[2000001];
    private int p, lo, hi, ret, sum = 0;

    @Override
    public void doMain() throws IOException {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      for (int i = 2; i < n; i++) {
        if (che[i]) { continue; }
        for (int j = 2 * i; j <= n; j += i) {
          che[j] = true;
        }
      }
      for (int i = 2; i <= n; i++) {
        if (!che[i]) { a[p++] = i; }
      }
      while (true) {
        if (sum >= n) {sum -= a[lo++];}
        else if (hi == p) {break;}
        else {sum += a[hi++];}
        if (sum == n) {ret++;}
      }
      System.out.println(ret);
    }
  }

  interface Solution {
    void doMain() throws IOException;
  }
}
