package leetCode.topInterView.Array;
import java.util.ArrayList;
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
    int[][] mtx = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
    List<Integer> res = solution.spiralOrder(mtx);
    for (Integer re : res) {
      System.out.println("re = " + re);
    }
  }

  public static SpiralMatrixInterface getSolution() {
    return new SpiralMatrixSolutionV2();
  }

  public static class SpiralMatrixSolutionV3 implements SpiralMatrixInterface {

    @Override
    public List<Integer> spiralOrder(int[][] matrix) {
      ArrayList<Integer> res = new ArrayList<>();
      if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        return res;
      }

      int rows = matrix.length;
      int columns = matrix[0].length;
      int top = 0, bottom = rows - 1, left = 0, right = columns - 1;
      while (top <= bottom && left <= right) {
        for (int i = left; i < right; i++) {
          res.add(matrix[top][i]);
        }
        top++;

        for (int i = top; i <= bottom; i++) {
          res.add(matrix[i][right]);
        }
        right--;

        if (top <= bottom) {
          for (int i = right; i >= left; i--) {
            res.add(matrix[bottom][i]);
          }
          bottom--;
        }

        if (left <= right) {
          for (int i = bottom; i >= top; i--) {
            res.add(matrix[i][left]);
          }
          left++;
        }
      }

      return res;
    }
  }

  public static class SpiralMatrixSolutionV2 implements SpiralMatrixInterface {

    @Override
    public List<Integer> spiralOrder(int[][] matrix) {
      List<Integer> result = new ArrayList<>();
      if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        return result;
      }

      int rows = matrix.length;
      int columns = matrix[0].length;
      int top = 0, bottom = rows - 1, left = 0, right = columns - 1;

      while (top <= bottom && left <= right) {
        // Traverse top row
        for (int i = left; i <= right; i++) {
          result.add(matrix[top][i]);
        }
        top++;

        // Traverse right column
        for (int i = top; i <= bottom; i++) {
          result.add(matrix[i][right]);
        }
        right--;

        // Check if there are remaining rows and columns
        if (top <= bottom) {
          // Traverse bottom row
          for (int i = right; i >= left; i--) {
            result.add(matrix[bottom][i]);
          }
          bottom--;
        }

        if (left <= right) {
          // Traverse left column
          for (int i = bottom; i >= top; i--) {
            result.add(matrix[i][left]);
          }
          left++;
        }
      }

      return result;
    }
  }

  public static class SpiralMatrixSolutionV1 implements SpiralMatrixInterface {

    int[] dx1 = {0, 1};
    int[] dy1 = {1, 0};
    int[] dx2 = {1, 0};
    int[] dy2 = {0, -1};
    int[] dx3 = {0, -1};
    int[] dy3 = {-1, 0};
    int[] dx4 = {-1, 0};
    int[] dy4 = {0, 1};
    int M = 0;
    int N = 0;

    List<Integer> lis = new ArrayList<>();

    @Override
    public List<Integer> spiralOrder(int[][] matrix) {
      if (matrix.length == 0) {
        return new ArrayList<>();
      }

      if (matrix.length == 1) {
        ArrayList<Integer> lis = new ArrayList<>();
        for (int i = 0; i < matrix[0].length; i++) {
          lis.add(matrix[0][i]);
        }
        return lis;
      }

      M = matrix.length;
      N = matrix[0].length;
      int[][] valid = new int[M][N];
      findWay(matrix, 0, 0, valid, 1);
      return lis;
    }

    private void findWay(int[][] matrix, int w, int h, int[][] valid, int pos) {
      if (w < 0 || h < 0 || valid[w][h] == 1) {
        return;
      }

      lis.add(matrix[w][h]);

      valid[w][h] = 1;
      if (pos == 1) {
        for (int i = 0; i < dx1.length; i++) {
          if (h + 1 == N) {
            pos = 2;
            findWay(matrix, w + dx2[i], h + dy2[i], valid, pos);
          } else {
            findWay(matrix, w + dx1[i], h + dy1[i], valid, pos);
          }
        }
      } else if (pos == 2) {
        for (int i = 0; i < dx2.length; i++) {
          if (w + 1 == M) {
            pos = 3;
            findWay(matrix, w + dx3[i], h + dy3[i], valid, pos);
          } else {
            findWay(matrix, w + dx2[i], h + dy2[i], valid, pos);
          }
        }
      } else if (pos == 3) {
        for (int i = 0; i < dx3.length; i++) {
          if (h - 1 == -1) {
            pos = 4;
            findWay(matrix, w + dx4[i], h + dy4[i], valid, pos);
          } else {
            findWay(matrix, w + dx3[i], h + dy3[i], valid, pos);
          }
        }
      } else {
        for (int i = 0; i < dx4.length; i++) {
          if (w - 1 == -1) {
            pos = 1;
            findWay(matrix, w + dx1[i], h + dy1[i], valid, pos);
          } else {
            findWay(matrix, w + dx4[i], h + dy4[i], valid, pos);
          }
        }
      }
    }
  }

  public interface SpiralMatrixInterface {

    List<Integer> spiralOrder(int[][] matrix);
  }
}
