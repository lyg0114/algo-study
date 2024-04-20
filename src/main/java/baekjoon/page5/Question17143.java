package baekjoon.page5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.page5
 * @url : https://www.acmicpc.net/problem/17143
 * @since : 19.04.24
 */
public class Question17143 {
  public static void main(String[] args) {
    Solution solution = new SolutionImpl();
    solution.doMain();
  }

  static class Cell {
    List<Shark> sharks;
    public Cell(List<Shark> shark) {
      this.sharks = shark;
    }
  }

  static class Shark {
    int speed, dir, size, status;
    public Shark(int speed, int dir, int size) {
      this.speed = speed;
      this.dir = dir;
      this.size = size;
      this.status = -1;
    }

    public int getBigSharkSize() {
      return size;
    }

    @Override
    public String
    toString() { return "Shark{" + size + '}'; }
  }

  // (r,c) -> 상어의 위치
  // s -> 속력
  // d -> 이동방향 (1 : 위, 2 : 아래, 3 : 오른쪽, 4 : 왼쪽)
  // z -> 크기
  static class SolutionImpl implements Solution {
    int R,C,M;
    int r,c,s,d,z;
    int res;
    Cell [][] board;
    int dx[] = {-1, 1, 0, 0};
    int dy[] = {-0, 0, 1, -1};

    @Override
    public void doMain() {
      Scanner sc = new Scanner(System.in);
      R = sc.nextInt();
      C = sc.nextInt();
      M = sc.nextInt();
      board = new Cell[R][C]; // 해당 위치에 상어 존재 : 1 , 상어 존재x : 0
      for (int i = 0; i < M; i++) {
        r = sc.nextInt();
        c = sc.nextInt();
        s = sc.nextInt();
        d = sc.nextInt();
        z = sc.nextInt();
        board[r - 1][c - 1] = new Cell(new ArrayList<>(List.of(new Shark(s, d - 1, z))));
      }

      printBoard(board);
      // 낙시왕의 낙시 로직
      for (int j = 0; j < C; j++) {
        for (int i = 0; i < R; i++) {
          if (board[i][j] != null && board[i][j].sharks != null && !board[i][j].sharks.isEmpty()) {
            res += board[i][j].sharks.get(0).getBigSharkSize();
            board[i][j].sharks = null; // 잡은 상어는 board에서 제거.
            printBoard(board);
            break;
          }
        }

        // 상어 이동 로직
        // 모든 상어 정보를 바탕으로 상어 이동
        for (int k = 0; k < R; k++) {
          for (int l = 0; l < C; l++) {
            if (board[k][l] != null && board[k][l].sharks != null && !board[k][l].sharks.isEmpty()) {
              Shark shark = board[k][l].sharks.get(0);
              if(shark.status == j) break;
              board[k][l].sharks = null; // 해당 위치에는 상어가 이동했으므로

              // 방향에 따른 이동 로직
              int dir = shark.dir;
              int x = k, y = l;
              for (int i = 0; i < shark.speed; i++) {
                x = x + dx[dir];
                y = y + dy[dir];
                if ((dir == 2 || dir == 3) && (y == 0 || y == C - 1)) { dir = switchingDir(dir); }
                if ((dir == 0 || dir == 1) && (x == 0 || x == R - 1)) { dir = switchingDir(dir); }
              }
              shark.dir = dir; // 상어의 이동 완료후 변경된 방향정보 업데이트

              // 한번 이동했던 녀석은 건너 뛴다 중복으로 이동하지 않도록처리.
              // 이동한 곳에 다른 상어가 있을경우 작은상어는 큰상어에게 먹힘 (큰 상어 정보만 남김)
              if (board[x][y] != null && board[x][y].sharks != null && !board[x][y].sharks.isEmpty()) {
                board[x][y].sharks.add(shark);
                Shark bigShark = null;
                int size = 0;
                for (Shark curShark : board[x][y].sharks) {
                  if (size < curShark.size) {
                    size = curShark.size;
                    bigShark = curShark;
                  }
                }
                bigShark.status = j;
                board[x][y].sharks = new ArrayList<>(List.of(bigShark));
              } else {
                shark.status = j;
                board[x][y] = new Cell(new ArrayList<>(List.of(shark)));
              }
            }
          }
        }
      }

      System.out.println("res = " + res);
    }

    // 현재 상어들의 상황을 디버깅 하기 위한 메소드
    private void printBoard(Cell[][] board) {
      for (int x = 0; x < board.length; x++) {
        for (int y = 0; y < board[x].length; y++) {
          String sharkStr = "[x]     ";
          if (board[x][y] != null && board[x][y].sharks != null) {
            sharkStr = board[x][y].sharks.get(0).toString();
          }
          System.out.print("[" + x + ", " + y + "] : " + sharkStr + " ");
        }
        System.out.println();
      }
      System.out.println();
    }

    // board의 경계에 도달했을경우 방향 전환 메소드
    private int switchingDir(int dir) {
      if(dir == 0) return 1;
      else if(dir == 1) return 0;
      else if(dir == 2) return 3;
      else if(dir == 3) return 2;
      else return -1;
    }
  }

  interface Solution {
    void doMain();
  }
}
