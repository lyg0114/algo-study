package leetCode.topInterView.tree;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.tree
 * @url : https://leetcode.com/explore/featured/card/top-interview-questions-easy/94/trees/625/
 * @since : 2023/04/06
 */
public class ValidateBinarySearchTree {

  public static void main(String[] args) {

    ValidateBinarySearchTreeInter solution = new ValidateBinarySearchTreeSolution();
/*
     5
    / \
   1   4
      / \
     3   6
*/

    TreeNode node1 = new TreeNode(1);
    TreeNode node5 = new TreeNode(5);
    TreeNode node4 = new TreeNode(4);
    TreeNode node3 = new TreeNode(3);
    TreeNode node6 = new TreeNode(6);

    node5.left = node1;
    node5.right = node4;
    node4.left = node3;
    node4.right = node6;
//    System.out.println(solution.isValidBST(node5));

    //##############################
    //##############################
    //##############################
/*
     2
    / \
   1   5
      / \
     4   6
*/
    TreeNode n1 = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(5);
    TreeNode n4 = new TreeNode(4);
    TreeNode n5 = new TreeNode(6);
    n2.left = n1;
    n2.right = n3;
    n3.left = n4;
    n3.right = n5;
    System.out.println(solution.isValidBST(n2));
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
