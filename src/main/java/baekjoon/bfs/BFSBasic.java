package baekjoon.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.bfs
 * @since : 2022/12/11
 */
public class BFSBasic {
  private static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
  private static int visited[] = new int[100];
  private static Integer[] nodes = {10, 12, 14, 16, 18, 20, 22, 24};
  List<Integer> integers = Arrays.asList(nodes);

  public static void main(String[] args) {
    for (int i = 0; i < 100; i++) {
      adj.add(new ArrayList<>());
    }

    adj.get(10).add(12);
    adj.get(10).add(14);
    adj.get(10).add(16);

    adj.get(12).add(18);
    adj.get(12).add(20);

    adj.get(20).add(22);
    adj.get(20).add(24);
    BFS(10);
    for (int i = 0; i < nodes.length; i++) {
      System.out.println(String.format("[ %d : %d ]", nodes[i], visited[nodes[i]]));
    }

    System.out.println(visited[24] - 1);
  }

  public static void BFS(int here) {
    Queue<Integer> queue = new LinkedList<>();
    visited[here] = 1;
    queue.add(here);
    while (queue.size() > 0) {
      Integer from = queue.poll();
      for (Integer there : adj.get(from)) {
        if (visited[there] > 0) {
          continue;
        }
        visited[there] = visited[from] + 1;
        queue.add(there);
      }
    }
  }
}
