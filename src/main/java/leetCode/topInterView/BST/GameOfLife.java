package leetCode.topInterView.BST;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.BST
 * @since : 2023/06/05
 */
public class GameOfLife {

  public static void main(String[] args) {
    GameOfLifeInterface solution = getSolution();
    int[][] mrx = {
        {1, 1},
        {1, 0}
    };
    solution.gameOfLife(mrx);
  }

  public static GameOfLifeInterface getSolution() {
    return new GameOfLifeSolutionV1();
  }

  public static class GameOfLifeSolutionV2 implements GameOfLifeInterface {

    private static final int[] dx = {0, 1, 0, -1, 1, -1, -1, 1};
    private static final int[] dy = {-1, 0, 1, 0, 1, -1, 1, -1};

    @Override
    public void gameOfLife(int[][] board) {
      int width = board.length;
      int height = board[0].length;
      int[][] nextBoard = new int[width][height];

      for (int i = 0; i < width; i++) {
        for (int j = 0; j < height; j++) {
          int liveNeighbors = countLiveNeighbors(i, j, board);
          if (board[i][j] == 1) {
            if (liveNeighbors < 2 || liveNeighbors > 3) {
              nextBoard[i][j] = 0;
            } else {
              nextBoard[i][j] = 1;
            }
          } else {
            if (liveNeighbors == 3) {
              nextBoard[i][j] = 1;
            } else {
              nextBoard[i][j] = 0;
            }
          }
        }
      }

      for (int i = 0; i < width; i++) {
        for (int j = 0; j < height; j++) {
          board[i][j] = nextBoard[i][j];
        }
      }
    }

    private int countLiveNeighbors(int x, int y, int[][] board) {
      int live = 0;
      for (int i = 0; i < 8; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (isValidCoordinate(nx, ny, board.length, board[0].length) && board[nx][ny] == 1) {
          live++;
        }
      }

      return live;
    }

    private boolean isValidCoordinate(int x, int y, int width, int height) {
      return x >= 0 && x < width && y >= 0 && y < height;
    }
  }

  public static class GameOfLifeSolutionV1 implements GameOfLifeInterface {

    private static int dx[] = {0, 1, 0, -1, 1, -1, -1, 1};
    private static int dy[] = {-1, 0, 1, 0, 1, -1, 1, -1};
    private List<Integer> res = new ArrayList<>();

    @Override
    public void gameOfLife(int[][] board) {
      int width = board.length;
      int height = board[0].length;
      for (int i = 0; i < width; i++) {
        for (int j = 0; j < height; j++) {
          checkCell(i, j, board);
        }
      }
      int idx = 0;
      for (int i = 0; i < width; i++) {
        for (int j = 0; j < height; j++) {
          if (idx < res.size()) {
            board[i][j] = res.get(idx++);
          }
        }
      }
    }

    private void checkCell(int x, int y, int[][] board) {
      int nx = 0, ny = 0;
      int live = 0, dead = 0;
      for (int i = 0; i < 8; i++) {
        try {
          nx = x + dx[i];
          ny = y + dy[i];
          if (board[nx][ny] == 1) {
            live++;
          } else {
            dead++;
          }
        } catch (ArrayIndexOutOfBoundsException e) {
          System.out.println("catch Exception");
        }
      }

      if (board[x][y] == 1) {
        if (live < 2) {
          res.add(0);
        } else if (live == 2 || live == 3) {
          res.add(1);
        } else {
          res.add(0);
        }
      } else {
        if (live == 3) {
          res.add(1);
        } else {
          res.add(0);
        }
      }
    }
  }

  public interface GameOfLifeInterface {

    void gameOfLife(int[][] board);
  }
}
