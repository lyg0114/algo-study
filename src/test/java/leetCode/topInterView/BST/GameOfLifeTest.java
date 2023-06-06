package leetCode.topInterView.BST;

import static org.junit.Assert.*;

import leetCode.topInterView.BST.GameOfLife.GameOfLifeInterface;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.BST
 * @since : 2023/06/06
 */
public class GameOfLifeTest {

  @Test
  public void test_gameOfLife_1() {
    GameOfLifeInterface solution = GameOfLife.getSolution();
    int[][] mrx = {
        {0, 1, 0},
        {0, 0, 1},
        {1, 1, 1},
        {0, 0, 0}
    };
    solution.gameOfLife(mrx);

    for (int i = 0; i < mrx.length; i++) {
      for (int j = 0; j < mrx[j].length; j++) {
        System.out.print(mrx[i][j] + ", ");
      }
      System.out.println();
    }
  }

  @Test
  public void test_gameOfLife_2() {
    GameOfLifeInterface solution = GameOfLife.getSolution();
    int[][] mrx = {
        {1, 1},
        {1, 0}
    };
    solution.gameOfLife(mrx);
  }

}