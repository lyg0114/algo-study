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

  public static class GameOfLifeSolutionV1 implements GameOfLifeInterface {

    private static int dx[] = {0, 1, 0, -1, 1, -1, -1, 1};
    private static int dy[] = {-1, 0, 1, 0, 1, -1, 1, -1};
    private List<Integer> res = new ArrayList<>();

    @Override
    public void gameOfLife(int[][] board) {
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[j].length; j++) {
          checkCell(i, j, board);
        }
      }
      int idx = 0;
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[j].length; j++) {
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
