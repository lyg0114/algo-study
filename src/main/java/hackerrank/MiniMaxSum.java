package hackerrank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : iyeong-gyo
 * @package : hackerrank
 * @since : 31.01.24
 */
public class MiniMaxSum {
  public static void main(String[] args) throws IOException {
    Solution solution = new SolutionImpl();
    solution.doMain();
  }

  static class SolutionImpl implements Solution {
    static long max = 0;
    static long min = Long.MAX_VALUE;

    @Override
    public void doMain() throws IOException {
      List<Integer> integers = List.of(1, 2, 3, 4, 5);
      miniMaxSum(integers);
      System.out.println(min + " " + max);
    }

    public void miniMaxSum(List<Integer> arr) {
      List<Long> longList = new ArrayList<>();
      for (Integer integer : arr) {
        longList.add((long) integer);
      }
      permute(0, 5, 4, longList);
    }

    public void permute(int depth, int n, int r, List<Long> arr) {
      if (r == depth) {
        long sum = 0;
        for (int i = 0; i < r; i++) { sum += arr.get(i); }
        if (sum > max) { max = sum; }
        if (sum < min) { min = sum; }
      }
      for (int i = depth; i < n; i++) {
        swap(i, depth, arr);
        permute(depth + 1, n, r, arr);
        swap(i, depth, arr);
      }
    }

    public void swap(int i, int j, List<Long> arr) {
      long tmp;
      tmp = arr.get(i);
      arr.set(i, arr.get(j));
      arr.set(j, tmp);
    }
  }

  interface Solution {
    void doMain() throws IOException;
  }
}
