package baekjoon.greedy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/*
===========
= example =
===========

 7 7 2
2 3 4 6 7 8 9
1 0 0 3 0 0 8
-1 0 2 3 0 22 10
-1 8 0 0 0 0 0
0 0 0 0 10 43 0
0 0 5 15 0 0 0
0 0 40 0 0 20 0

 7 8 1
2 3 4 5 6 7 8 9
1 0 0 0 3 0 0 8
-1 0 5 2 3 0 22 10
-1 8 0 0 0 0 0 0
0 0 0 0 0 10 43 0
0 0 5 0 15 0 0 0
0 0 40 0 0 0 20 0

 8 8 1
2 3 4 5 6 7 8 9
1 0 0 0 3 0 0 8
-1 0 5 2 3 0 22 10
-1 8 0 0 0 0 0 0
0 0 0 0 0 10 43 0
0 0 5 0 15 0 0 0
0 0 40 0 0 0 20 0
0 0 40 0 0 0 20 0

 */

/**
 * @author : iyeong-gyo
 * @package : baekjoon.greedy
 * @since : 29.12.23
 */
public class Qustion17144 {
  public static void main(String[] args) throws IOException {
    Solution solution = new SolutionImplV3();
    solution.doMain();
  }

  static class SolutionImplV3 implements Solution {
    static class Point {
      public int x;
      public int y;
      public Point(int x, int y) {
        this.x = x;
        this.y = y;
      }
    }

    private int R = 0;
    private int C = 0;
    private int T = 0;
    private int[][] mtx;
    private int[][] tmp;
    private List<Point> v1;
    private List<Point> v2;

    // 반시계
    private int[] dx1 = {0, -1, 0, 1};
    private int[] dy1 = {1, 0, -1, 0};
    // 시계
    private int[] dx2 = {0, 1, 0, -1};
    private int[] dy2 = {1, 0, -1, 0};

    @Override
    public void doMain() throws IOException {
      Scanner sc = new Scanner(System.in);
      R = sc.nextInt();
      C = sc.nextInt();
      T = sc.nextInt();
      mtx = new int[R][C];
      boolean flag = true;
      for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
          mtx[i][j] = sc.nextInt();
          if (mtx[i][j] == -1) {
            if (flag) {
              v1 = chung(i, j, dx1, dy1);
              flag = false;
            } else {
              v2 = chung(i, j, dx2, dy2);
            }
          }
        }
      }

      for (int i = 0; i < T; i++) {
        miseGo();
        go(v1);
        go(v2);
      }

      int ret = 0;
      for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
          if (mtx[i][j] != -1) {
            ret += mtx[i][j];
          }
        }
      }
      System.out.println(ret);
    }

    private void go(List<Point> v) {
      for (int i = v.size() - 1; i > 0; i--) {
        mtx[v.get(i).x][v.get(i).y] = mtx[v.get(i - 1).x][v.get(i - 1).y];
      }
      mtx[v.get(0).x][v.get(0).y] = 0;
    }

    private void miseGo() {
      tmp = new int[R][C];
      int spread, nx, ny;
      for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
          if (mtx[i][j] > 0) {
            spread = mtx[i][j] / 5;
            int cnt = 0;
            for (int k = 0; k < 4; k++) {
              nx = i + dx1[k];
              ny = j + dy1[k];
              if (ny < 0 || nx < 0 || ny >= C || nx >= R || mtx[nx][ny] == -1) {
                continue;
              }
              tmp[nx][ny] += spread;
              cnt++;
            }
            mtx[i][j] = mtx[i][j] - (spread * cnt);
          }
        }
      }

      for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
          mtx[i][j] += tmp[i][j];
        }
      }
    }

    private List<Point> chung(int x, int y, int[] dx, int[] dy) {
      int orX = x;
      int orY = y;
      int dir = 0;
      int nx, ny;
      List<Point> points = new ArrayList<>();
      while (true) {
        nx = x + dx[dir];
        ny = y + dy[dir];
        if (nx == orX && ny == orY) {
          break;
        }
        if (ny >= C || nx < 0 || ny < 0 || nx >= R) {
          dir++;
          nx = x + dx[dir];
          ny = y + dy[dir];
        }
        points.add(new Point(nx, ny));
        x = nx;
        y = ny;
      }
      return points;
    }
  }


  // #########################################################
  // #########################################################
  // #########################################################
  // #########################################################

  static class SolutionImplV2 implements Solution {
    static int[][] a, temp;
    static int n, m, t, ret;
    static List<Point> v1, v2;

    static int[] dy1 = {0, -1, 0, 1};
    static int[] dx1 = {1, 0, -1, 0};
    static int[] dy2 = {0, 1, 0, -1};
    static int[] dx2 = {1, 0, -1, 0};

    static class Point {
      int y, x;
      Point(int y, int x) {
        this.y = y;
        this.x = x;
      }
    }

    private void mise_go(int[] dy, int[] dx) {
      temp = new int[n][m];
      Queue<Point> q = new LinkedList<>();
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (a[i][j] != -1 && a[i][j] > 0) {
            q.add(new Point(i, j));
          }
        }
      }

      while (!q.isEmpty()) {
        Point p = q.poll();
        int y = p.y;
        int x = p.x;
        int spread = a[y][x] / 5;
        for (int i = 0; i < 4; i++) {
          int ny = y + dy[i];
          int nx = x + dx[i];
          if (ny < 0 || ny >= n || nx < 0 || nx >= m || a[ny][nx] == -1) {
            continue;
          }
          temp[ny][nx] += spread;
          a[y][x] -= spread;
        }
      }

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          a[i][j] += temp[i][j];
        }
      }
    }

    private List<Point> chung(int sy, int sx, int[] dy, int[] dx) {
      List<Point> v = new ArrayList<>();
      int cnt = 0;
      int y = sy;
      int x = sx;

      while (true) {
        int ny = y + dy[cnt];
        int nx = x + dx[cnt];

        if (ny == sy && nx == sx) break;
        if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
          cnt++;
          ny = y + dy[cnt];
          nx = x + dx[cnt];
        }
        if (ny == sy && nx == sx) break;

        y = ny;
        x = nx;
        v.add(new Point(ny, nx));
      }

      return v;
    }

    static void go(List<Point> v) {
      for (int i = v.size() - 1; i > 0; i--) {
        a[v.get(i).y][v.get(i).x] = a[v.get(i - 1).y][v.get(i - 1).x];
      }
      a[v.get(0).y][v.get(0).x] = 0;
    }

    @Override
    public void doMain() throws IOException {
      Scanner scanner = new Scanner(System.in);
      n = scanner.nextInt();
      m = scanner.nextInt();
      t = scanner.nextInt();
      a = new int[n][m];

      boolean flag = true;

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          a[i][j] = scanner.nextInt();
          if (a[i][j] == -1) {
            if (flag) {
              v1 = chung(i, j, dy1, dx1);
              flag = false;
            } else {
              v2 = chung(i, j, dy2, dx2);
            }
          }
        }
      }

      for (int i = 0; i < t; i++) {
        mise_go(dy1, dx1);
        go(v1);
        go(v2);
      }

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (a[i][j] != -1) {
            ret += a[i][j];
          }
        }
      }

      System.out.println(ret);
    }
  }

  interface Solution {
    void doMain() throws IOException;
  }
}
