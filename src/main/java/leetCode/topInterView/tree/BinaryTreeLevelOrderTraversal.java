package leetCode.topInterView.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.tree
 * @since : 2023/04/10
 */
public class BinaryTreeLevelOrderTraversal {

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

    Solution solution = new Solution();
    List<List<Integer>> lists = solution.levelOrder(node3);
    lists.forEach(i -> {
      i.forEach(System.out::println);
      System.out.println("==================");
    });
  }

  private static class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
      if (root == null) {
        return null;
      }
      List<List<Integer>> lists = new ArrayList<>();
      List<Integer> roots = new ArrayList<>();
      roots.add(root.val);
      lists.add(roots);
      traversal(root, lists);
      return lists.stream().filter(i -> !(i.isEmpty()))
          .collect(Collectors.toList());
    }

    public void traversal(TreeNode node, List<List<Integer>> lists) {
      if (node == null) {
        return;
      }

      ArrayList<Integer> nums = new ArrayList<>();
      if (node.left != null) {
        nums.add(node.left.val);
      }
      if (node.right != null) {
        nums.add(node.right.val);
      }
      lists.add(nums);

      traversal(node.left, lists);
      traversal(node.right, lists);
    }
  }
}
