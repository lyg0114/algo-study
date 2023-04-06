package leetCode.topInterView.tree;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.tree
 * @url : https://leetcode.com/explore/featured/card/top-interview-questions-easy/94/trees/555/
 * @since : 2023/04/06
 */
public class MaximumDepthBinaryTree {

  public static void main(String[] args) {
    MaximumDepthBinaryTreeInter solution = new MaximumDepthBinaryTreeSolution();
    solution.maxDepth(null);

  }
}

class MaximumDepthBinaryTreeSolution implements MaximumDepthBinaryTreeInter {

  @Override
  public int maxDepth(TreeNode root) {
    return 0;
  }
}

interface MaximumDepthBinaryTreeInter {

  int maxDepth(TreeNode root);
}
