package leetCode.topInterView.Array;

import java.util.List;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Array
 * @url :https://leetcode.com/problems/spiral-matrix/?envType=featured-list&envId=top-interview-questions
 * @since : 2023/06/15
 */
public class SpiralMatrix {

  public static void main(String[] args) {

    SpiralMatrixInterface solution = getSolution();
    int[][] mtx = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    List<Integer> res = solution.spiralOrder(mtx);
    for (Integer re : res) {
      System.out.println("re = " + re);
    }
  }

  public static SpiralMatrixInterface getSolution() {
    return new SpiralMatrixSolutionV1();
  }

  public static class SpiralMatrixSolutionV1 implements SpiralMatrixInterface {

    @Override
    public List<Integer> spiralOrder(int[][] matrix) {
      return null;
    }
  }

  public interface SpiralMatrixInterface {

    List<Integer> spiralOrder(int[][] matrix);
  }
}
