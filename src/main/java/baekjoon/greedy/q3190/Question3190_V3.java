package baekjoon.greedy.q3190;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.greedy
 * @since : 05.01.24
 */
public class Question3190_V3 implements Solution {

  static class Pair {
    int first, second;
    public Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }

  static int n, k, x, y, l, t, time;
  static int[][] board, visited;
  static Deque<Pair> dqSnakeLocation;
  static Queue<Pair> changeDirTime;

  static int dir = 0;
  static final int[] dx = {0, 1, 0, -1};
  static final int[] dy = {1, 0, -1, 0};

  @Override
  public void doMain() throws IOException {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    k = sc.nextInt();
    board = new int[n][n];
    visited = new int[n][n];
    dqSnakeLocation = new ArrayDeque<>();
    changeDirTime = new LinkedList<>();

    for (int i = 0; i < k; i++) { //사과 좌표
      x = sc.nextInt();
      y = sc.nextInt();
      board[--x][--y] = 1;
    }

    l = sc.nextInt();
    for (int i = 0; i < l; i++) {
      t = sc.nextInt();
      char c = sc.next().charAt(0);
      if (c == 'D') {
        changeDirTime.add(new Pair(t, 1));// 오른쪽으로 꺽을 경우 ==> 1
      } else {
        changeDirTime.add(new Pair(t, 3)); // 왼쪽으로 꺽을 경우 ==> 3
      }
    }
    dqSnakeLocation.add(new Pair(0, 0)); // 뱀의 시작 위치

    while (true) {
      time++;
      Pair pair = dqSnakeLocation.peekFirst();
      x = pair.first;
      y = pair.second;
      int nx = x + dx[dir];
      int ny = y + dy[dir];

      if (ny >= n || ny < 0 || nx >= n || nx < 0 || visited[nx][ny] == 1) {
        break;
      }

      if (board[nx][ny] == 0) {
        Pair last = dqSnakeLocation.peekLast();
        visited[last.first][last.second] = 0;
        dqSnakeLocation.pollLast();
      } else {
        board[nx][ny] = 0;
      }

      visited[nx][ny] = 1;
      dqSnakeLocation.addFirst(new Pair(nx, ny));

      if (changeDirTime.peek() != null && time == changeDirTime.peek().first) {
        dir = (dir + changeDirTime.poll().second) % 4;
      }
    }
    System.out.println(time);
  }
}
