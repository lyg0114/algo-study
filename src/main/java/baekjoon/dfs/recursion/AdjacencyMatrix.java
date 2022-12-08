package baekjoon.dfs.recursion;

/**
 * @author : iyeong-gyo
 * @package : baekjoon
 * @since : 2022/12/03
 */
public class AdjacencyMatrix {
  private static int[][] arr = new int[10][10];
  private static int visited[] = new int[10];

  public static void main(String[] args) {
    arr[1][2] = 1;
    arr[2][1] = 1;

    arr[1][3] = 1;
    arr[3][1] = 1;

    arr[2][4] = 1;
    arr[4][2] = 1;

    arr[3][4] = 1;
    arr[4][3] = 1;

    arr[4][5] = 1;
    arr[5][4] = 1;

    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        if (arr[i][j] == 1 && visited[i] == 0) {
          travers(i);
        }
      }
    }
  }

  private static void travers(int from) {
    visited[from] = 1;
    System.out.println("current = " + from);
    for (int i = 0; i < 10; i++) {
      if(visited[i] == 1) continue;
      if(arr[from][i]==1){
        travers(i);
      }
    }
    return;
  }
}
