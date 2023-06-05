package leetCode.topInterView.BST;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.BST
 * @since : 2023/06/05
 */
public class GameOfLife {

  public static void main(String[] args) {
    GameOfLifeInterface solution = getSolution();
    int[][] mrx = {
        {0, 1, 0},
        {0, 0, 1},
        {1, 1, 1},
        {0, 0, 0}
    };
    solution.gameOfLife(mrx);
  }

  public static GameOfLifeInterface getSolution() {
    return new GameOfLifeSolutionV1();
  }

  public static class GameOfLifeSolutionV1 implements GameOfLifeInterface {

    private static int dx[] = {0, 1, 0, -1};
    private static int dy[] = {-1, 0, 1, 0};
    private static int nx = 0;
    private static int ny = 0;

    @Override
    public void gameOfLife(int[][] board) {
      List<HashMap<Integer, Integer>> lis = new ArrayList<>();
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[j].length; j++) {
          dfs(i, j, board, board[j].length, board.length);
        }
      }
    }

    private void dfs(int x, int y, int[][] board, int width, int height) {
      for (int i = 0; i < 4; i++) {
        nx = x + dx[i];
        ny = y + dy[i];
        if (ny < 0 || nx < 0 || ny >= height || nx >= width) {
          continue;
        }
        dfs(nx, ny, board, width, height);
      }
    }

  }

  public interface GameOfLifeInterface {

    void gameOfLife(int[][] board);
  }
}
