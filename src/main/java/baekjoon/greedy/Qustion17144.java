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

 7 7 1
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
    Solution solution = new SolutionImplV2();
    solution.doMain();
  }

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
