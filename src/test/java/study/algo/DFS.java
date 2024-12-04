package study.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author : iyeong-gyo
 * @package : study.algo
 * @since : 01.02.24
 */
public class DFS {

  static class Graph {

    private Map<Integer, List<Integer>> graph;

    public Graph() {

      this.graph = new HashMap<>();

    }

    public void addEdge(int u, int v) {

      graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);

      graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);

    }

    public void dfs(int node, Set<Integer> visited) {

      if (!visited.contains(node)) {

        System.out.print(node + " ");
        visited.add(node);

        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {

          dfs(neighbor, visited);

        }

      }
    }
  }

  public static void main(String[] args) {
    Graph graph = new Graph();
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 2);
    graph.addEdge(2, 0);
    graph.addEdge(2, 3);
    graph.addEdge(3, 3);
    Set<Integer> visited = new HashSet<>();
    System.out.println("DFS traversal starting from node 0:");
    graph.dfs(0, visited);
  }
}
