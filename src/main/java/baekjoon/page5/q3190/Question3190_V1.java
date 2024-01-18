package baekjoon.page5.q3190;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.greedy
 * @since : 05.01.24
 */
public class Question3190_V1  implements Solution{

  static class Point {
    public int x;
    public int y;
    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  static class ChangeDir {
    int delay;
    String dir;
    public ChangeDir(int delay, String dir) {
      this.delay = delay;
      this.dir = dir;
    }
  }

  static class Board {
    public int[][] cells;
    public final int boardSize;
    public int headX = 0;
    public int headY = 0;
    public int tailX = -1;
    public int tailY = -1;

    public Board(int boardSize) {
      this.cells = new int[boardSize][boardSize];
      this.cells[headX][headY] = 3;
      this.boardSize = boardSize;
    }

    public void moveLeft() {
      int[][] temp = new int[boardSize][boardSize];
      for (int i = 0; i < boardSize; i++) {
        for (int j = 0; j < boardSize; j++) {
          temp[i][j] = cells[boardSize - j - 1][i];
        }
      }
      System.arraycopy(temp, 0, cells, 0, boardSize);
      getHeadLocation();
    }

    public void moveRight() {
      int[][] temp = new int[boardSize][boardSize];
      for (int i = 0; i < boardSize; i++) {
        for (int j = 0; j < boardSize; j++) {
          temp[i][j] = cells[j][boardSize - i - 1];
        }
      }
      System.arraycopy(temp, 0, cells, 0, boardSize);
      getHeadLocation();
    }

    public void getHeadLocation() {
      for (int i = 0; i < cells.length; i++) {
        for (int j = 0; j < cells.length; j++) {
          if (cells[i][j] == 3) {
            headX = i;
            headY = j;
            break;
          }
        }
      }
    }

    public void checkNextTail() {
      int[] dx = {0, 0, 1, -1};
      int[] dy = {1, -1, 0, 0};
      for (int i = 0; i < 4; i++) {
        if (cells[tailX + dx[i]][tailY + dy[i]] == 2) {
          tailX = tailX + dx[i];
          tailY = tailY + dy[i];
        }
      }
    }
  }

  @Override
  public void doMain() throws IOException {
    Scanner sc = new Scanner(System.in);
    int boardSize = sc.nextInt();
    int countOfApple = sc.nextInt();
    List<Point> appleLoc = new ArrayList<>();
    for (int i = 0; i < countOfApple; i++) {
      appleLoc.add(new Point(sc.nextInt(), sc.nextInt()));
    }
    int changeDirCnt = sc.nextInt();
    Queue<ChangeDir> changeDirs = new LinkedList<>();
    for (int i = 0; i < changeDirCnt; i++) {
      changeDirs.add(new ChangeDir(sc.nextInt(), sc.next()));
    }
    Board board = new Board(boardSize);
    for (Point apple : appleLoc) {
      board.cells[apple.x][apple.y] = 1;
    }

    int sec = 0;
    while (true) {
      sec++;
      if (changeDirs.peek() != null && changeDirs.peek().delay == sec) {
        ChangeDir dir = changeDirs.poll();
        if (dir.dir.equals("D")) {
          board.moveRight();
        } else {
          board.moveLeft();
        }
      }

      if ((board.headY + 1) == boardSize || board.cells[board.headX][board.headY + 1] == 2) {
        break;
      } else {
        if (board.cells[board.headX][board.headY] == 1) { // 사과 먹은 경우
          if (board.tailX == -1 && board.tailY == -1) {
            board.tailX = 4;
            board.tailY = 4;
          }
          board.cells[board.headX][++board.headY] = 3;
        } else {
          board.cells[board.tailX][board.tailY] = 0;
          board.checkNextTail();
          board.cells[board.headX][++board.headY] = 3;
        }
      }
    }
    System.out.println(sec);
  }
}
