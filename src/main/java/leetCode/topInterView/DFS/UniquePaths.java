package leetCode.topInterView.DFS;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.DFS
 * @since : 2023/06/13
 */
public class UniquePaths {

  public static void main(String[] args) {
    UniquePathsInterface solution = getSolution();
    int res = solution.uniquePaths(3, 2);
    System.out.println("res = " + res);
  }

  public static UniquePathsInterface getSolution() {
    return new UniquePathsSolutionV1();
  }

  public static class UniquePathsSolutionV1 implements UniquePathsInterface {

    int[] dx = {1, 0};
    int[] dy = {0, 1};
    int res = 0;

    @Override
    public int uniquePaths(int m, int n) {
      int[][] mx = new int[m][n];
      findWay(mx, 0, 0, m, n);
      return res;
    }

    public void findWay(int[][] mx, int cx, int cy, int m, int n) {
      if (cx == (n - 1) && cy == (m - 1)) {
        res++;
        return;
      }

      if (!((0 <= cx && cx < n) && (0 <= cy && cy < m))) {
        return;
      }

      for (int i = 0; i < 2; i++) {
        findWay(mx, cx + dx[i], cy + dy[i], m, n);
      }
    }
  }


  public interface UniquePathsInterface {

    int uniquePaths(int m, int n);
  }
}
