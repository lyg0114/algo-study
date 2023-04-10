package leetCode.topInterView.tree;

import java.util.ArrayList;
import java.util.List;

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
    for (List<Integer> list : lists) {
      for (Integer integer : list) {
        System.out.println("integer = " + integer);
      }
      System.out.println("------------------------------------");
    }
  }

  private static class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
      if (root == null) {
        return null;
      }
      List<List<Integer>> lists = new ArrayList<>();
      List<Integer> roots = new ArrayList<>();
      lists.add(roots);

      traversal(root, lists);
      return lists;
    }

    public void traversal(TreeNode node, List<List<Integer>> lists) {
      if (node == null) {
        return;
      }

      traversal(node.left, lists);
      traversal(node.right, lists);

      ArrayList<Integer> nums = new ArrayList<>();
      if (node.left != null) {
        nums.add(node.left.val);
      }
      if (node.right != null) {
        nums.add(node.right.val);
      }
      lists.add(nums);
    }
  }
}
