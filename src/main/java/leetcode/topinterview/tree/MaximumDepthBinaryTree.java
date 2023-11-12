package leetcode.topinterview.tree;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.tree
 * @url : https://leetcode.com/explore/featured/card/top-interview-questions-easy/94/trees/555/
 * @since : 2023/04/06
 */
public class MaximumDepthBinaryTree {

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

    MaximumDepthBinaryTreeInter solution = getSolution();
    System.out.println(solution.maxDepth(node3));
  }

  private static MaximumDepthBinaryTreeInter getSolution() {
    return new MaximumDepthBinaryTreeSolution();
  }
}

class MaximumDepthBinaryTreeSolution implements MaximumDepthBinaryTreeInter {

  private int maxDepth = 0;

  @Override
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int depth = 1;
    return bfs(root, depth);
  }

  public int bfs(TreeNode node, int depth) {
    if (node.left == null && node.right == null) {
      if (depth > maxDepth) {
        maxDepth = depth;
      }
      return depth;
    }
    if (node.left != null) {
      depth++;
      bfs(node.left, depth);
      depth--;
    }

    if (node.right != null) {
      depth++;
      bfs(node.right, depth);
      depth--;
    }

    return maxDepth;
  }
}

class MaximumDepthBinaryTreeSolution2 implements MaximumDepthBinaryTreeInter {

  @Override
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftDepth = maxDepth(root.left);
    int rightDepth = maxDepth(root.right);
    return 1 + Math.max(rightDepth, leftDepth);
  }
}

interface MaximumDepthBinaryTreeInter {

  int maxDepth(TreeNode root);
}
