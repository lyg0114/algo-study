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
  private int[][] visited = new int[5][5];
  private int nx = 0;
  private int ny = 0;
  private int ret = 0;
  private int maxCnt = 0;
  private int waterLevel;

  void dfs(int x, int y) {
    visited[x][y] = 1;
    for (int i = 0; i < 4; i++) {
      ny = y + dy[i];
      nx = x + dx[i];
      if (ny < 0 || nx < 0 || ny >= 5 || nx >= 5) {
        continue;
      }
      if (matirx[nx][ny] > waterLevel && visited[nx][ny] == 0) {
        dfs(nx, ny);
      }
    }
    return;
  }

  public int getSafetyAreaCnt() {
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        if (matirx[i][j] > waterLevel && visited[i][j] == 0) {
          ret++;
          dfs(i, j);
        }
      }
    }
    return ret;
  }

  public int getMaxSafetyAreaCnt() {
    int currentMaxCnt;
    for (int i = 0; i < 9; i++) {
      waterLevel = i;
      clearVisited();
      currentMaxCnt = getSafetyAreaCnt();
      ret = 0;
      if (currentMaxCnt > maxCnt) {
        maxCnt = currentMaxCnt;
      }
    }
    return maxCnt;
  }

  private void clearVisited() {
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        visited[i][j] = 0;
      }
    }
  }
}

public class SafetyArea {

  public static void main(String[] args) {
    CalculateSafetyAreaCount calSafetyCnt = new CalculateSafetyAreaCount();
//    int safetyAreaCnt = calSafetyCnt.getSafetyAreaCnt();
//    System.out.println("safetyAreaCnt = " + safetyAreaCnt);
    int maxSafetyAreaCnt = calSafetyCnt.getMaxSafetyAreaCnt();
    System.out.println("maxSafetyAreaCnt = " + maxSafetyAreaCnt);
  }
}
