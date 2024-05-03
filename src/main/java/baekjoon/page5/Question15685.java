package baekjoon.page5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.page5
 * @url : https://www.acmicpc.net/problem/15685
 * @since : 23.04.24
 */
public class Question15685 {

  public static void main(String[] args) throws IOException {
    Solution solution = new SolutionImplV1();
    solution.doMain();
  }

  static class SolutionImplV1 implements Solution {
    static final int RIGHT = 0;
    static final int UP = 1;
    static final int LEFT = 2;
    static final int DOWN = 3;
    static final int LENGTH = 101;
    static boolean[][] map = new boolean[LENGTH][LENGTH];

    @Override
    public void doMain() throws IOException {
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt(); // 커브의 개수
      while (N-- > 0) {
        int x = sc.nextInt();
        int y = sc.nextInt();
        int d = sc.nextInt(); // 시작 방향
        int g = sc.nextInt(); // 세대
        draw(x, y, getDirections(d, g));
      }
      System.out.println(getNumberOfSquares());
    }

    public static List<Integer> getDirections(int d, int g) {
      List<Integer> directions = new ArrayList<>();
      directions.add(d);
      while ((g--) > 0) {
        for (int i = directions.size() - 1; i >= 0; i--) {
          int direction = (directions.get(i) + 1) % 4;
          directions.add(direction);
        }
      }
      return directions;
    }

    public void draw(int x, int y, List<Integer> directions) {
      map[x][y] = true;
      for (int direction : directions) {
        switch (direction) {
          case RIGHT: map[++x][y] = true; break;
          case UP: map[x][--y] = true; break;
          case LEFT: map[--x][y] = true; break;
          case DOWN: map[x][++y] = true; break;
        }
      }
    }

    private int getNumberOfSquares() {
      int count = 0;
      for (int x = 0; x < LENGTH-1; x++) {
        for (int y = 0; y < LENGTH-1; y++) {
          if (map[x][y] && map[x + 1][y] && map[x][y + 1] && map[x + 1][y + 1])
            count++;
        }
      }
      return count;
    }
  }

  interface Solution {
    void doMain() throws IOException;
  }
}
