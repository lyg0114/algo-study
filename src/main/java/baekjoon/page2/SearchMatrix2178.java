package baekjoon.page2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.page2
 * @since : 2022/12/11
 */
class Position {
  int x;
  int y;

  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}

class SearchMatrix{
  private int dx[] = {0, 1, 0, -1};
  private int dy[] = {-1, 0, 1, 0};
  private int nx = 0;
  private int ny = 0;

  private int[][] matirx = {
          {1, 0, 1, 1, 1, 1},
          {1, 0, 1, 0, 1, 0},
          {1, 0, 1, 0, 1, 1},
          {1, 1, 1, 0, 1, 1}
  };
  private int visited[][] = new int[100][100];

  public int[][] getVisited() {
    return visited;
  }

  public void bfs(int x, int y){
    Queue<Position> queue = new LinkedList<>();
    visited[x][y] = 1;
    queue.add(new Position(0,0));
    while (queue.size() > 0) {
      Position poll = queue.poll();
      for (int i = 0; i < 4; i++) {
        nx = poll.getX() + dx[i];
        ny = poll.getY() + dy[i];
        if (ny < 0 || nx < 0 || ny >= 5 || nx >= 4) {
          continue;
        }
        if (matirx[nx][ny] == 1 && visited[nx][ny] == 0) {
          System.out.println("[" + nx + " : " + ny + "]");
          visited[nx][ny] = visited[poll.getX()][poll.getY()] + 1;
          queue.add(new Position(nx, ny));
        }
      }
    }
  }

}

public class SearchMatrix2178 {
  public static void main(String[] args) {
    SearchMatrix searchMatrix = new SearchMatrix();
    searchMatrix.bfs(0,0);
    System.out.println(searchMatrix.getVisited()[3][4]);
  }
}
