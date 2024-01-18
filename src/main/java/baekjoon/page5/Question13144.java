package baekjoon.page5;

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
      long start = 0, end = 0, ret = 0;
      int N = Integer.parseInt(br.readLine());
      int[] chkDuplicate = new int[100001];
      StringTokenizer st = new StringTokenizer(br.readLine());
      int[] nums = new int[N];
      for (int i = 0; i < N; i++) {
        nums[i] = Integer.parseInt(st.nextToken());
      }

      while (end < N) {
        if (chkDuplicate[nums[(int) end]] == 0) {
          chkDuplicate[nums[(int) end]]++;
          end++;
        } else {
          ret += (end - start);
          chkDuplicate[nums[(int) start]]--;
          start++;
        }
      }

      ret += (end - start) * (end - start + 1) / 2;
      System.out.println(ret);
    }
  }

  interface Solution {

    void doMain() throws IOException;
  }
}




