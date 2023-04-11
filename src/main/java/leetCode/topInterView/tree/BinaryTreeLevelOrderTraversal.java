package leetCode.topInterView.tree;

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

  public static class BinaryTreeLevelOrderTraversalSolution3 implements BinaryTreeLevelOrderTraversalInterface {

    @Override
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> results = new ArrayList<>();
      if (root == null) {
        return results;
      }

      Map<Integer, List<Integer>> levelMap = new HashMap<>();
      traverse(root, levelMap, 1);

      for (int level : levelMap.keySet()) {
        results.add(levelMap.get(level));
      }

      return results;
    }

    private void traverse(TreeNode node, Map<Integer, List<Integer>> levelMap, int level) {
      if (node == null) {
        return;
      }

      List<Integer> levelList = levelMap.getOrDefault(level, new ArrayList<>());
      levelList.add(node.val);
      levelMap.put(level, levelList);

      traverse(node.left, levelMap, level + 1);
      traverse(node.right, levelMap, level + 1);
    }
  }
}
