package leetCode.topInterView.easy.Array;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.easy.Array
 * @since : 2023/03/07
 */
public class RotateImage {

  public static void main(String[] args) {
    RotateImageSolution rotateImageSolution = new RotateImageSolution();
    int[][] matrix = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    rotateImageSolution.rotate(matrix);

    printMatrix(matrix);
  }

  private static void printMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
//        System.out.print("[" + i + ", " + j + "] : " + matrix[i][j] + " ");
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println("");
    }
  }
}

class RotateImageSolution {

  public void rotate(int[][] matrix) {
  }
}
