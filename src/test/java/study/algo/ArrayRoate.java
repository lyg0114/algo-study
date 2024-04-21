package study.algo;

import java.util.Arrays;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : study
 * @since : 02.01.24
 */
public class ArrayRoate {

  @Test
  public void rightRotateArrayTest() {
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
    rightRotateArray(originalArray);
    printArray(originalArray);
    System.out.println();
  }

  void rightRotateArray(int[][] original) {
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

  @Test
  public void leftRotateArrayTest() {
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
    leftArray(originalArray);
    printArray(originalArray);
    System.out.println();
  }

  void leftArray(int[][] original) {
    int n = original.length;
    int[][] rotated = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        rotated[i][j] = original[j][n - i - 1];
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
