package baekjoon.page2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.page2
 * @since : 2022/12/11
 */
public class SearchMatrix2178 {
    public static void main(String[] args) {
        SearchMatrix searchMatrix = new SearchMatrix();
        searchMatrix.bfs(0, 0);
        searchMatrix.printResult();
    }
}

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

class SearchMatrix {
    private int dx[] = {0, 1, 0, -1};
    private int dy[] = {-1, 0, 1, 0};
    private int nx = 0;
    private int ny = 0;
    private int width;
    private int heigh;
    private int [][] matirx;
    private int [][] visited;

    public void printResult() {
        System.out.println(visited[width - 1][heigh - 1]);
    }

    public SearchMatrix() {
        Scanner scanner = new Scanner(System.in);
        width = Integer.parseInt(scanner.next());
        heigh = Integer.parseInt(scanner.next());
        matirx = new int[width][heigh];
        visited = new int[width][heigh];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < heigh; j++) {
                int value = Integer.parseInt(scanner.next());
                matirx[i][j] = value;
            }
        }
    }

    public void bfs(int x, int y) {
        Queue<Position> queue = new LinkedList<>();
        visited[x][y] = 1;
        queue.add(new Position(x, y));
        while (queue.size() > 0) {
            Position poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                nx = poll.getX() + dx[i];
                ny = poll.getY() + dy[i];
                if (ny < 0 || nx < 0 || ny >= heigh || nx >= width) {
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
