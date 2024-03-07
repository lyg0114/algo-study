package baekjoon.page5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.greedy
 * @since : 26.12.23
 */
public class Question17825 {
  public static void main(String[] args) throws IOException {
    Solution solution = new SolutionV1();
    solution.doMain();
  }

  static class SolutionV1 implements Solution {
    static class Node {
      int score, blue, red;
      boolean isBlue = false;
      public Node(int score, int red) {
        this.score = score;
        this.red = red;
      }
    }

    private static int max = 0, permu[], step[], now[];
    private static boolean[] existCheck;
    private static Node[] map;

    @Override
    public void doMain() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      map = new Node[43];
      permu = new int[10];
      step = new int[10];
      for (int i = 0; i < 10; i++) {
        step[i] = Integer.parseInt(st.nextToken());
      }
      for (int i = 0; i <= 40; i += 2) {
        map[i] = new Node(i, i + 2);
      }
      map[10].isBlue = map[20].isBlue = map[30].isBlue = true;
      map[10].blue = 11;
      map[20].blue = 17;
      map[30].blue = 31;

      map[11] = new Node(13, 13);
      map[13] = new Node(16, 15);
      map[15] = new Node(19, 25);
      map[17] = new Node(22, 19);
      map[19] = new Node(24, 25);
      map[25] = new Node(25, 37);
      map[31] = new Node(28, 33);
      map[33] = new Node(27, 35);
      map[35] = new Node(26, 25);
      map[37] = new Node(30, 39);
      map[39] = new Node(35, 40);
      map[42] = new Node(0, 42);

      permu[0] = 0;
      permu(9, 0);
      System.out.println(max);
    }

    private void permu(int n, int k) {
      if (n == k) {
        now = new int[4];
        existCheck = new boolean[43];
        move();
        return;
      }
      for (int i = 0; i < 4; i++) {
        permu[k] = i;
        permu(n, k + 1);
        permu[k] = -1; // 굳이 할필요 없음
      }
    }

    private void move() {
      int score = 0;
      for (int i = 0; i < 10; i++) {
        int end = horseMove(permu[i], step[i]);
        if (end == -1) {
          return;
        }
        now[permu[i]] = end;
        score += map[end].score;
      }
      if (max < score) {
        max = score;
      }
    }

    private int horseMove(int horse, int step) {
      int temp = now[horse];
      for (int i = 0; i < step; i++) {
        if (i == 0 && map[temp].isBlue) {
          temp = map[temp].blue;
          continue;
        }
        temp = map[temp].red;
      }
      if (temp <= 40 && existCheck[temp]) {
        return -1;
      } else {
        existCheck[now[horse]] = false;
        existCheck[temp] = true;
        return temp;
      }
    }
  }

  interface Solution {
    void doMain() throws IOException;
  }
}
