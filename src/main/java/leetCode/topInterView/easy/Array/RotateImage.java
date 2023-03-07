package leetCode.topInterView.easy.Array;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.easy.Array
 * @since : 2023/03/07
 *

  [0,0], [0,1], [0,2],
  [1,0], [1,1], [1,2],
  [2,0], [2,1], [2,2],

 */
public class RotateImage {

  public static void main(String[] args) {
    RotateImageSolution rotateImageSolution
        = new RotateImageSolution();
    int[][] matrix1 = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    rotateImageSolution.rotate(matrix1);
  }
}

class RotateImageSolution {

  public void rotate(int[][] matrix) {
    upsideDown(matrix);
    diagonal(matrix);
  }

  private void upsideDown(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n / 2; i++) {
      for (int j = 0; j < n; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[n - i - 1][j];
        matrix[n - i - 1][j] = temp;

      }
    }
  }

  private void diagonal(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }
  }
}
