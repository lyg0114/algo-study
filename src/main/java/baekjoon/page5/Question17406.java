package baekjoon.page5;

import static java.util.Collections.swap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.greedy.q3190
 * @since : 20.01.24
 */
public class Question17406 {
  interface Solution {
    void doMain() throws IOException;
  }

  public static void main(String[] args) throws IOException {
    Solution solution = new SolutionImpl();
    solution.doMain();
  }

  static class SolutionImpl implements Solution {
    static class Pos {
      int originX;
      int originY;
      int x;
      int y;
      public Pos(int x, int y) {
        this.x = x;
        this.y = y;
        this.originX = x;
        this.originY = y;
      }
      public void nextLt() { this.x++; this.y++; }
      public void nextRt() { this.x++; this.y--; }
      public void nextLd() { this.x--; this.y++; }
      public void nextRd() { this.x--; this.y--; }
      public void refresh() { this.x = originX; this.y = originY;}
    }

    static class CalculateInfo {
      Pos lt,rt,ld,rd;
      int r, c, s;
      public CalculateInfo(int r, int c, int s) {
        this.r = r;
        this.c = c;
        this.s = s;
        this.lt = new Pos(r - s - 1, c - s - 1);
        this.rt = new Pos(r - s - 1, c + s - 1);
        this.ld = new Pos(r + s - 1, c - s - 1);
        this.rd = new Pos(r + s - 1, c + s - 1);
      }
      public void next() { lt.nextLt(); rt.nextRt(); ld.nextLd(); rd.nextRd(); }
      public boolean isValid(int[][] visit) { return visit[lt.x][lt.y + 1] != 1; }
      public void refresh(){ lt.refresh(); rt.refresh(); ld.refresh(); rd.refresh(); }
    }

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int[][] A, visit, copy;
    int n;
    int m;
    int k;
    int res = Integer.MAX_VALUE;;

    @Override
    public void doMain() throws IOException {
      Scanner sc = new Scanner(System.in);
      n = sc.nextInt();
      m = sc.nextInt();
      k = sc.nextInt();
      A = new int[n][m];
      visit = new int[n][m];
      for (int i = 0; i < n; i++) { for (int j = 0; j < m; j++) { A[i][j] = sc.nextInt(); } }
      List<CalculateInfo> calculateInfos = new ArrayList<>();
      for (int i = 0; i < k; i++) { calculateInfos.add(new CalculateInfo(sc.nextInt(), sc.nextInt(), sc.nextInt())); }
      int size = calculateInfos.size();
      permuteRec(0, size, size, calculateInfos);
      System.out.println(res);
    }

    private int[][] deepCopy(int[][] original) {
      int[][] copy = new int[original.length][];
      for (int i = 0; i < original.length; i++) {
        copy[i] = original[i].clone();
      }
      return copy;
    }

    public void permuteRec(int depth, int num, int r, List<CalculateInfo> calculateInfos) {
      if (r == depth) {
        int[][] loadlCopy = deepCopy(A);
        for (CalculateInfo calculateInfo : calculateInfos) {
          visit = new int[n][m];
          calculateResult(calculateInfo, loadlCopy); //results 를 B를 사용해서 계산한다.
          calculateInfo.refresh();
        }
        for (int i = 0; i < n; i++) {
          int tmp = 0;
          for (int j = 0; j < m; j++) { tmp += loadlCopy[i][j]; }
          if(res > tmp){ res = tmp; }
        }
      }

      for (int i = depth; i < num; i++) {
        swap(calculateInfos, i, depth );
        permuteRec(depth + 1, num, r, calculateInfos);
        swap(calculateInfos, i, depth );
      }
    }

    private void calculateResult(CalculateInfo calculateInfo, int [][] lodalCopy) {
      Queue<Integer> valueQueue = new LinkedList<>();
      Queue<Pos> posQueue = new LinkedList<>();
      int x = calculateInfo.lt.x;
      int y = calculateInfo.lt.y;
      while (true) {
        int status = 0;
        while (true) {
          valueQueue.add(lodalCopy[x][y]);
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
          lodalCopy[nextPos.x][nextPos.y] = valueQueue.poll();
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
  }
}
