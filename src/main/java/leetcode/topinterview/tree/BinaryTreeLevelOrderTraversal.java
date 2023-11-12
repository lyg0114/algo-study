package leetcode.topinterview.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.tree
 * @since : 2023/04/10
 */
public class BinaryTreeLevelOrderTraversal {

  public interface BinaryTreeLevelOrderTraversalInterface {

    List<List<Integer>> levelOrder(TreeNode root);
  }

  public static class BinaryTreeLevelOrderTraversalSolution implements
      BinaryTreeLevelOrderTraversalInterface {

    @Override
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> results = new ArrayList<>();
      if (root == null) {
        return results;
      }
      HashMap<Integer, Queue<Integer>> map = new HashMap<>();
      Queue<Integer> roots = new LinkedList<>();
      roots.add(root.val);
      int level = 1;
      map.put(level, roots);
      traversal(root, map, ++level);
      for (Integer index : map.keySet()) {
        Queue<Integer> queue = map.get(index);
        if (queue.size() > 0) {
          results.add((List<Integer>) queue);
        }
      }
      return results;
    }

    public void traversal(TreeNode node, HashMap<Integer, Queue<Integer>> map, int level) {
      if (node == null) {
        return;
      }
      Queue<Integer> nDataQueue = new LinkedList<>();
      if (node.left != null) {
        nDataQueue.offer(node.left.val);
      }
      if (node.right != null) {
        nDataQueue.offer(node.right.val);
      }

      Queue<Integer> queue = map.get(level);
      if (queue != null) {
        queue.addAll(nDataQueue);
      } else {
        map.put(level, nDataQueue);
      }

      traversal(node.left, map, ++level);
      level--;
      traversal(node.right, map, ++level);
    }
  }

  public static class BinaryTreeLevelOrderTraversalSolution2 implements
      BinaryTreeLevelOrderTraversalInterface {

    @Override
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> result = new ArrayList<>();
      if (root == null) {
        return result;
      }
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);

      while (!queue.isEmpty()) {
        int size = queue.size();
        List<Integer> level = new ArrayList<>();
        for (int i = 0; i < size; i++) {
          TreeNode node = queue.poll();
          level.add(node.val);
          if (node.left != null) {
            queue.offer(node.left);
          }
          if (node.right != null) {
            queue.offer(node.right);
          }
        }
        result.add(level);
      }

      return result;
    }

  }

  public static class BinaryTreeLevelOrderTraversalSolution3
      implements BinaryTreeLevelOrderTraversalInterface {

    @Override
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> results = new ArrayList<>(); // 결과를 저장할 List<List<Integer>>형 리스트를 초기화합니다.
      if (root == null) { //루트 노드가 null인 경우 빈 리스트를 반환합니다.
        return results;
      }

      Map<Integer, List<Integer>> levelMap = new HashMap<>(); // 각 레벨마다 노드 값을 저장할 리스트를 맵에 저장합니다.
      traverse(root, levelMap, 1); // 재귀적으로 각 노드를 탐색하며 레벨마다 노드 값을 맵에 저장하는 메소드를 호출합니다.

      for (int level : levelMap.keySet()) { //맵에서 각 레벨의 리스트를 꺼내 결과 리스트에 추가합니다.
        results.add(levelMap.get(level));
      }

      return results;
    }

    private void traverse(TreeNode node, Map<Integer, List<Integer>> levelMap, int level) {
      if (node == null) { //노드가 null인 경우 메소드를 종료합니다.
        return;
      }

      List<Integer> levelList = levelMap.getOrDefault(level, new ArrayList<>()); // 현재 레벨에 해당하는 리스트를 맵에서 꺼내거나 새로 생성합니다.

      levelList.add(node.val); // 현재 노드의 값을 리스트에 추가합니다.
      levelMap.put(level, levelList); // 맵에 현재 레벨과 리스트를 저장합니다.

      traverse(node.left, levelMap, level + 1); // 왼쪽 서브트리를 재귀적으로 탐색합니다.
      traverse(node.right, levelMap, level + 1);  // 오른쪽 서브트리를 재귀적으로 탐색합니다.
    }
  }

  public static class BinaryTreeLevelOrderTraversalSolution4
      implements BinaryTreeLevelOrderTraversalInterface {

    @Override
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> results = new ArrayList<>(); // Initialize a List<List<Integer>> to store the results.
      if (root == null) { // If the root node is null, return an empty list.
        return results;
      }

      Map<Integer, List<Integer>> levelMap = new HashMap<>(); // Create a Map to store a list of node values for each level.
      traverse(root, levelMap, 1); // Call the traversal method recursively to store node values in the map.

      for (int level : levelMap.keySet()) { // Retrieve the list of node values for each level from the map and add it to the results list.
        results.add(levelMap.get(level));
      }

      return results;
    }

    private void traverse(TreeNode node, Map<Integer, List<Integer>> levelMap, int level) {
      if (node == null) { // If the node is null, return.
        return;
      }

      List<Integer> levelList = levelMap.getOrDefault(level, new ArrayList<>()); // Retrieve the list of node values for the current level from the map or create a new list if it doesn't exist.

      levelList.add(node.val); // Add the current node value to the list.
      levelMap.put(level, levelList); // Store the level and list in the map.

      traverse(node.left, levelMap, level + 1); // Recursively traverse the left subtree.
      traverse(node.right, levelMap, level + 1); // Recursively traverse the right subtree.
    }
  }
}
