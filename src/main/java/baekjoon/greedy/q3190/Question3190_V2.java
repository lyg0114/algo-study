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
public class Question3190_V2 implements Solution {
  static int n, k, l, y, x, t, dir = 1;
  static int[][] board, visited;
  static int time;
  static Deque<Pair> dqSnakeLocation;
  static Queue<Pair> changeDirTime;
  static final int[] dy = {-1, 0, 1, 0};
  static final int[] dx = {0, 1, 0, -1};

  static class Pair {
    int first, second;
    public Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }

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
      y = sc.nextInt();
      x = sc.nextInt();
      board[--y][--x] = 1;
    }

    l = sc.nextInt();
    for (int i = 0; i < l; i++) {
      t = sc.nextInt();
      char c = sc.next().charAt(0);
      if (c == 'D') { // 오른쪽으로 꺽을 경우 ==> 1
        changeDirTime.add(new Pair(t, 1));
      } else { // 왼쪽으로 꺽을 경우 ==> 3
        changeDirTime.add(new Pair(t, 3));
      }
    }

    dqSnakeLocation.add(new Pair(0, 0)); // 뱀의 시작 위치

    while (!dqSnakeLocation.isEmpty()) {
      time++; // 1초 경과
      Pair pair = dqSnakeLocation.peekFirst();
      //다음 좌표 계산
      y = pair.first;
      x = pair.second;
      int ny = y + dy[dir];
      int nx = x + dx[dir];
      if (ny >= n || ny < 0 || nx >= n || nx < 0 || visited[ny][nx] == 1) {
        break;
      }

      if (board[ny][nx] == 0) { // 사과가 없는경우
        Pair last = dqSnakeLocation.peekLast();
        visited[last.first][last.second] = 0;
        dqSnakeLocation.pollLast();
      } else { // 사과가 있는경우
        board[ny][nx] = 0;
      }

      visited[ny][nx] = 1;
      dqSnakeLocation.addFirst(new Pair(ny, nx));
      if (changeDirTime.peek() != null && time == changeDirTime.peek().first) {
        dir = (dir + changeDirTime.poll().second) % 4;
      }
    }

    System.out.println(time);
  }
}
