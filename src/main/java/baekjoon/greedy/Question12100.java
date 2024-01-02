package baekjoon.greedy;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.greedy
 * @since : 01.01.24
 */
public class Question12100 {
  public static void main(String[] args) throws IOException {
    Solution solution = new SolutionImpl();
    solution.doMain();
  }

  static class SolutionImpl implements Solution {
    static class GameBoard {
      int[][] cells = new int[24][24];
      void rotate90() {
        int[][] temp = new int[24][24];
        for (int i = 0; i < boardSize; i++) {
          for (int j = 0; j < boardSize; j++) {
            temp[i][j] = cells[boardSize - j - 1][i];
          }
        }
        System.arraycopy(temp, 0, cells, 0, temp.length);
      }

      void move() {
        int[][] temp = new int[24][24];
        for (int i = 0; i < boardSize; i++) {
          int colIndex = -1, mergeFlag = 0;
          for (int j = 0; j < boardSize; j++) {
            if (cells[i][j] == 0) {
              continue;
            }
            if (mergeFlag != 0 && cells[i][j] == temp[i][colIndex]) {
              temp[i][colIndex] *= 2;
              mergeFlag = 0;
            } else {
              temp[i][++colIndex] = cells[i][j];
              mergeFlag = 1;
            }
          }
          for (colIndex++; colIndex < boardSize; colIndex++) {
            temp[i][colIndex] = 0;
          }
        }
        System.arraycopy(temp, 0, cells, 0, temp.length);
      }

      void getMax() {
        for (int i = 0; i < boardSize; i++) {
          for (int j = 0; j < boardSize; j++) {
            maxCellValue = Math.max(maxCellValue, cells[i][j]);
          }
        }
      }
    }

    static int maxCellValue, boardSize;
    @Override
    public void doMain() throws IOException {
      Scanner scanner = new Scanner(System.in);
      boardSize = scanner.nextInt();
      GameBoard gameBoard = new GameBoard();
      for (int i = 0; i < boardSize; i++) {
        for (int j = 0; j < boardSize; j++) {
          gameBoard.cells[i][j] = scanner.nextInt();
        }
      }
      exploreGamePaths(gameBoard, 0);
      System.out.println(maxCellValue);
    }

    void exploreGamePaths(GameBoard gameBoard, int moveCount) {
      if (moveCount == 5) {
        gameBoard.getMax();
        return;
      }
      for (int i = 0; i < 4; i++) {
        GameBoard nextBoard = new GameBoard();
        System.arraycopy(gameBoard.cells, 0, nextBoard.cells, 0, gameBoard.cells.length);
        nextBoard.move();
        exploreGamePaths(nextBoard, moveCount + 1);
        gameBoard.rotate90();
      }
    }
  }

  interface Solution {

    void doMain() throws IOException;
  }
}

