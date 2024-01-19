package baekjoon.page5.q17406;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.greedy
 * @since : 16.01.24
 */
public class Question17406_V1 implements Solution{

  static class Pos {
    int x;
    int y;
    public Pos(int x, int y) {
      this.x = x;
      this.y = y;
    }
    public void nextLt() { this.x++; this.y++; }
    public void nextRt() { this.x++; this.y--; }
    public void nextLd() { this.x--; this.y++; }
    public void nextRd() { this.x--; this.y--; }
  }

  static class CalculateInfo {
    Pos lt,rt,ld,rd;
    public CalculateInfo(int r, int c, int s) {
      lt = new Pos(r - s - 1, c - s - 1);
      rt = new Pos(r - s - 1, c + s - 1);
      ld = new Pos(r + s - 1, c - s - 1);
      rd = new Pos(r + s - 1, c + s - 1);
    }
    public void next() { lt.nextLt(); rt.nextRt(); ld.nextLd(); rd.nextRd(); }
    public boolean isValid(int[][] visit) { return visit[lt.x][lt.y + 1] != 1; }
  }

  int[] dx = {0, 1, 0, -1};
  int[] dy = {1, 0, -1, 0};
  int[][] A, visit;


  @Override
  public void doMain() throws IOException {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int k = sc.nextInt();
    A = new int[n][m];
    visit = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        A[i][j] = sc.nextInt();
      }
    }

    List<CalculateInfo> calculateInfos = new ArrayList<>();
    for (int i = 0; i < k; i++) { calculateInfos.add(new CalculateInfo(sc.nextInt(), sc.nextInt(), sc.nextInt())); }
    Queue<Integer> valueQueue = new LinkedList<>();
    Queue<Pos> posQueue = new LinkedList<>();
    for (CalculateInfo calculateInfo : calculateInfos) {
      int x = calculateInfo.lt.x;
      int y = calculateInfo.lt.y;
      while (true) {
        int status = 0;
        while (true) {
          valueQueue.add(A[x][y]);
          x = x + dx[status];
          y = y + dy[status];
          if (x == calculateInfo.rt.x && y == calculateInfo.rt.y) { status++; }
          if (x == calculateInfo.rd.x && y == calculateInfo.rd.y) { status++; }
          if (x == calculateInfo.ld.x && y == calculateInfo.ld.y) { status++; }
          if (status == 3 && x == calculateInfo.lt.x && y == calculateInfo.lt.y) {
            break;
          }
        }

        x = calculateInfo.lt.x;
        y = calculateInfo.lt.y + 1;
        status = 0;
        while (true) {
          posQueue.add(new Pos(x, y));
          x = x + dx[status];
          y = y + dy[status];
          if (x == calculateInfo.rt.x && y == calculateInfo.rt.y) { status++; }
          if (x == calculateInfo.rd.x && y == calculateInfo.rd.y) { status++; }
          if (x == calculateInfo.ld.x && y == calculateInfo.ld.y) { status++; }
          if (status == 3 && x == calculateInfo.lt.x - 1 && y == calculateInfo.lt.y) {
            break;
          }
        }

        while (!posQueue.isEmpty() && !valueQueue.isEmpty()) {
          Pos nextPos = posQueue.poll();
          A[nextPos.x][nextPos.y] = valueQueue.poll();
          visit[nextPos.x][nextPos.y] = 1;
        }

        calculateInfo.next();
        x = calculateInfo.lt.x;
        y = calculateInfo.lt.y;

        if (!calculateInfo.isValid(visit)) {
          break;
        }
      }
    }

    int res =  Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      int tmp = 0;
      for (int j = 0; j < m; j++) { tmp += A[i][j]; }
      if(res > tmp){ res = tmp; }
    }

    System.out.println(res);
  }
}
