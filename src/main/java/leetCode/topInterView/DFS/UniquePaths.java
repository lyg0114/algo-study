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

  public static class UniquePathsSolutionV2 implements UniquePathsInterface {

    @Override
    public int uniquePaths(int m, int n) {
      // 경로 수를 저장할 2차원 배열 생성
      int[][] dp = new int[m][n];

      // 시작 지점에서의 경로 수는 1
      dp[0][0] = 1;

      // 첫 번째 열의 모든 칸에는 왼쪽에서 오는 경로만 존재
      for (int i = 1; i < m; i++) {
        dp[i][0] = 1;
      }

      // 첫 번째 행의 모든 칸에는 위쪽에서 오는 경로만 존재
      for (int j = 1; j < n; j++) {
        dp[0][j] = 1;
      }

      // 나머지 칸에 대한 경로 수 계산
      for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
          // 왼쪽과 위쪽에서 오는 경로 수를 더함
          dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
      }

      // 우측 하단 모서리의 경로 수 반환
      return dp[m - 1][n - 1];
    }
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
