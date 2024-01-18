package baekjoon.page5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.greedy
 * @since : 28.12.23
 * @name : 두수의 합
 */
public class Question3273 {
  public static void main(String[] args) throws IOException {
    Solution solution = new SolutionImpl();
    solution.doMain();
  }

  static class SolutionImpl implements Solution {
    @Override
    public void doMain() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }
      int start = 0;
      int end = arr.length - 1;
      int target = Integer.parseInt(br.readLine());
      int ret = 0;
      Arrays.sort(arr);
      while (start < end) {
        if (arr[start] + arr[end] == target) {
          ret++;
          start++;
          end--;
        } else if (arr[start] + arr[end] > target) {
          end--;
        } else {
          start++;
        }
      }
      System.out.println(ret);
    }
  }

  interface Solution {
    void doMain() throws IOException;
  }
}
