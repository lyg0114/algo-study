package baekjoon.page2;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.dfs.recursion
 * @since : 2022/12/17
 */
public class OrganicCabbage {
  private static int dx[] = {0, 1, 0, -1};
  private static int dy[] = {-1, 0, 1, 0};
  private static int[][] matirx = {
      {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
      {0, 0, 1, 1, 0, 0, 0, 1, 1, 1},
      {0, 0, 0, 0, 1, 0, 0, 1, 1, 1}
  };
  private static int[][] visited = new int[104][104];
  private static int nx = 0;
  private static int ny = 0;
  private static int ret = 0;

  static void dfs(int x, int y) {
    visited[x][y] = 1;
    for (int i = 0; i < 4; i++) {
      ny = y + dy[i];
      nx = x + dx[i];
      if (ny < 0 || nx < 0 || ny >= 10 || nx >= 6) {
        continue;
      }
      if (matirx[nx][ny] == 1 && visited[nx][ny] == 0) {
        dfs(nx, ny);
      }
    }
    return;
  }

  public static void main(String[] args) {
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 10; j++) {
        if (matirx[i][j] == 1 && visited[i][j] == 0) {
          ret++;
          dfs(i, j);
        }
      }
    }
    System.out.println("#########");
    System.out.println(ret);
    System.out.println("#########");
  }

}
