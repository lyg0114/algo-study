package baekjoon;

/**
 * @author : iyeong-gyo
 * @package : baekjoon
 * @since : 2022/12/03
 */
public class AdjacencyMatrix {

  public static void main(String[] args) {
    int arr[][] = {
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };
//    arr[1][2] = 1;
//    arr[2][1] = 1;
//    arr[1][3] = 1;
//    arr[3][1] = 1;
//    arr[3][4] = 1;
//    arr[4][3] = 1;

    travers(arr, 0, 0);

  }

  private static void travers(int[][] arr, int start1, int start2) {
    for (int i = start1; i < 10; i++) {
      for (int j = start2; j < 10; j++) {
        if (arr[i][j] == 1 && arr[j][i] == 1) {
          travers(arr, j, i);
        }
        System.out.println("[" + i + "]");
      }
    }
  }

}
