package study;

import java.util.Arrays;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : study
 * @since : 02.01.24
 */
public class ArrayRoateTest {

  @Test
  public void rightRotateArray() {
    int n = 4;
    int[][] originalArray = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        originalArray[i][j] = i * n + j + 1;
      }
    }

    System.out.println("Original Array:");
    printArray(originalArray);

    System.out.println("\n right Rotated Array:");
    rotateArray(originalArray);
    printArray(originalArray);
    System.out.println();
  }

  void rotateArray(int[][] original) {
    int n = original.length;
    int[][] rotated = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        rotated[i][j] = original[n - j - 1][i];
      }
    }

    for (int i = 0; i < n; i++) {
      System.arraycopy(rotated[i], 0, original[i], 0, n);
    }
  }

  static void printArray(int[][] array) {
    for (int[] row : array) {
      System.out.println(Arrays.toString(row));
    }
  }
}
