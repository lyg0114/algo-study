package baekjoon.page2;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.page2
 * @since : 2022/12/17
 */
class CalculateSafetyAreaCount {
  private static int dx[] = {0, 1, 0, -1};
  private static int dy[] = {-1, 0, 1, 0};
  private static int[][] matirx = {
      {6, 8, 2, 6, 2},
      {3, 2, 3, 4, 6},
      {6, 7, 3, 3, 2},
      {7, 2, 5, 3, 6},
      {8, 9, 5, 2, 7}
  };
  private static int[][] visited = new int[5][5];
  private static int nx = 0;
  private static int ny = 0;
  private static int ret = 0;

  static void dfs(int x, int y) {
    visited[x][y] = 1;
    for (int i = 0; i < 4; i++) {
      ny = y + dy[i];
      nx = x + dx[i];
      if (ny < 0 || nx < 0 || ny >= 5 || nx >= 5) {
        continue;
      }
      if (matirx[nx][ny] == 1 && visited[nx][ny] == 0) {
        dfs(nx, ny);
      }
    }
    return;
  }
}

public class SafetyArea {
  public static void main(String[] args) {
  }
}
