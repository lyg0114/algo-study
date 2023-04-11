package leetCode.topInterView.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.tree
 * @since : 2023/04/10
 */
public class BinaryTreeLevelOrderTraversal {

  /*
        3
       / \
      9   20
          / \
         15  7
 */

  public static void main(String[] args) {
    TreeNode node3 = new TreeNode(3);
    TreeNode node9 = new TreeNode(9);
    TreeNode node20 = new TreeNode(20);
    TreeNode node15 = new TreeNode(15);
    TreeNode node7 = new TreeNode(7);
    node3.left = node9;
    node3.right = node20;
    node20.left = node15;
    node20.right = node7;

    SolInterface solution = getSolInterface();
    List<List<Integer>> lists = solution.levelOrder(node3);
    lists.forEach(i -> {
      i.forEach(System.out::println);
      System.out.println("==================");
    });
  }

  private static SolInterface getSolInterface() {
    return new Solution2();
  }

  public interface SolInterface {

    List<List<Integer>> levelOrder(TreeNode root);
  }

  public static class Solution implements SolInterface {

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
        if(queue.size()>0){
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

  public static class Solution2 implements SolInterface {

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
}
