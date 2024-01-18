package baekjoon.page5;

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

      public int[][] cells = new int[boardSize][boardSize];

      void rotate90() {
        int[][] rotateTemp = new int[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
          for (int j = 0; j < boardSize; j++) {
            rotateTemp[i][j] = cells[boardSize - j - 1][i];
          }
        }
        // temp에다 cell을 90도 회전후 배열을 만들고 복사
        System.arraycopy(rotateTemp, 0, cells, 0, rotateTemp.length);
      }

      void move() {
        int[][] moveTemp = new int[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
          int colIndex = -1;
          int isInsert = 0;
          for (int j = 0; j < boardSize; j++) {

            if (cells[i][j] == 0) {
              continue;
            }

            if (isInsert != 0 && cells[i][j] == moveTemp[i][colIndex]){
              moveTemp[i][colIndex] *= 2;
              isInsert = 0;
            }
            else {
              moveTemp[i][++colIndex] = cells[i][j];
              isInsert = 1;
            }

          }
          for (colIndex++; colIndex < boardSize; colIndex++) {
            moveTemp[i][colIndex] = 0;
          }
        }
        System.arraycopy(moveTemp, 0, cells, 0, moveTemp.length);
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

