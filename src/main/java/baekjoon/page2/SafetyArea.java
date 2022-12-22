package baekjoon.page2;
import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.page2
 * @since : 2022/12/17
 */
class CalculateSafetyAreaCount2468 {
  private static int dx[] = {0, 1, 0, -1};
  private static int dy[] = {-1, 0, 1, 0};
  private static int[][] matirx;
  private int[][] visited;
  private int matrixWidth;
  private int matrixHeigh;
  private int nx = 0;
  private int ny = 0;
  private int ret = 0;
  private int maxCnt = 0;
  private int waterLevel;
  private int maxWaterLevel = 0;

  void dfs(int x, int y) {
    visited[x][y] = 1;
    for (int i = 0; i < 4; i++) {
      nx = x + dx[i];
      ny = y + dy[i];
      if (ny < 0 || nx < 0 || ny >= matrixWidth || nx >= matrixHeigh) {
        continue;
      }
      if (matirx[nx][ny] > waterLevel && visited[nx][ny] == 0) {
        dfs(nx, ny);
      }
    }
    return;
  }

  public int getSafetyAreaCnt() {
    for (int i = 0; i < matrixWidth; i++) {
      for (int j = 0; j < matrixHeigh; j++) {
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
    for (int i = 0; i < maxWaterLevel; i++) {
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
    for (int i = 0; i < matrixWidth; i++) {
      for (int j = 0; j < matrixHeigh; j++) {
        visited[i][j] = 0;
      }
    }
  }

  public void setMetrix() {
    Scanner scan = new Scanner(System.in);
    int N = Integer.parseInt(scan.next());
    matrixWidth = N;
    matrixHeigh = N;
    visited = new int[matrixWidth][matrixHeigh];
    matirx = new int[matrixWidth][matrixHeigh];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        matirx[i][j] = Integer.parseInt(scan.next());
        if(matirx[i][j] > maxWaterLevel){
          maxWaterLevel = matirx[i][j];
        }
      }
    }
  }
}

public class SafetyArea {
  public static void main(String[] args) {
    CalculateSafetyAreaCount2468 calSafetyCnt = new CalculateSafetyAreaCount2468();
    calSafetyCnt.setMetrix();
    int maxSafetyAreaCnt = calSafetyCnt.getMaxSafetyAreaCnt();
    System.out.println("maxSafetyAreaCnt = " + maxSafetyAreaCnt);
  }
}
