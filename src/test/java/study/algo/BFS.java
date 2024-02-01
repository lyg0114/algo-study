package study.algo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author : iyeong-gyo
 * @package : study.algo
 * @since : 01.02.24
 */
public class BFS {
  static class Graph {
    private Map<Integer, List<Integer>> graph;

    public Graph() {
      this.graph = new HashMap<>();
    }

    public void addEdge(int u, int v) {
      graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
      graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    public void bfs(int startNode) {
      Queue<Integer> queue = new ArrayDeque<>();
      Set<Integer> visited = new HashSet<>();

      queue.add(startNode);
      visited.add(startNode);

      while (!queue.isEmpty()) {
        int node = queue.poll();
        System.out.print(node + " ");

        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
          if (!visited.contains(neighbor)) {
            queue.add(neighbor);
            visited.add(neighbor);
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    Graph graph = new Graph();
    graph.addEdge(0,1);
    graph.addEdge(1,2);
    graph.addEdge(1,3);
    graph.addEdge(2,3);
    graph.addEdge(2,4);
    graph.addEdge(3,4);
    graph.addEdge(3,5);
    graph.addEdge(5,6);
    graph.addEdge(5,7);
    graph.addEdge(6,8);

//    graph.addEdge(0, 1);
//    graph.addEdge(0, 2);
//    graph.addEdge(1, 2);
//    graph.addEdge(2, 0);
//    graph.addEdge(2, 3);
//    graph.addEdge(3, 3);
    System.out.println("BFS traversal starting from node 0:");
    graph.bfs(0);
  }
}
