package baekjoon.dfs;

/**
 * @author : iyeong-gyo
 * @package : baekjoon
 * @since : 2022/12/07
 */
public class MatrixSearch {
  private static int dy[] = {-1, 0, 1, 0};
  private static int dx[] = {0, 1, 0, -1};
  private static int[][] matirx = {
      {0, 0, 0, 0, 0},
      {0, 1, 0, 0, 0},
      {0, 1, 1, 0, 0},
      {0, 0, 1, 0, 0},
      {0, 0, 0, 0, 0}
  };
  private static int[][] visited = new int[5][5];
  private static int nx = 0;
  private static int ny = 0;

  public static void main(String[] args) {
    searchNextPosition(1, 1);
  }

  private static void searchNextPosition(int x, int y) {
    System.out.println("nx : ny" + "[" + x + "," + y + "]");
    visited[x][y] = 1;

    for (int i = 0; i < 4; i++) {
      nx = x + dx[i];
      ny = y + dy[i];
      if (matirx[nx][ny] == 1 && visited[nx][ny] == 0) {
        searchNextPosition(nx, ny);
      }
    }
  }
}
