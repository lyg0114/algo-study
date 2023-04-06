package leetCode.topInterView.tree;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.tree
 * @url : https://leetcode.com/explore/featured/card/top-interview-questions-easy/94/trees/625/
 * @since : 2023/04/06
 */
public class ValidateBinarySearchTree {

  public static void main(String[] args) {
  }
}

class ValidateBinarySearchTreeSolution implements ValidateBinarySearchTreeInter {

  @Override
  public boolean isValidBST(TreeNode root) {
    return helper(root, null, null);
  }

  private boolean helper(TreeNode node, Integer min, Integer max) {
    if (node == null) {
      return true;
    }
    if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
      return false;
    }
    boolean left = helper(node.left, min, node.val);
    boolean right = helper(node.right, node.val, max);
    return left && right;
  }
}

interface ValidateBinarySearchTreeInter {

  boolean isValidBST(TreeNode root);
}
