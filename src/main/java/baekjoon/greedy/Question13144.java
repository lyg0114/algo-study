package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.greedy
 * @since : 27.12.23
 */
public class Question13144 {

  public static void main(String[] args) throws IOException {
    Solution solution = new SolutionImpl();
    solution.doMain();
  }

  static class SolutionImpl implements Solution {

    @Override
    public void doMain() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      long s = 0, e = 0, ret = 0;
      int n = Integer.parseInt(br.readLine());
      int[] cnt = new int[100001];
      StringTokenizer st = new StringTokenizer(br.readLine());
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = Integer.parseInt(st.nextToken());
      }

      while (e < n) {
        if (cnt[a[(int) e]] == 0) {
          cnt[a[(int) e]]++;
          e++;
        } else {
          ret += (e - s);
          cnt[a[(int) s]]--;
          s++;
        }
      }

      ret += (e - s) * (e - s + 1) / 2;
      System.out.println(ret);
    }
  }

  interface Solution {

    void doMain() throws IOException;
  }
}




