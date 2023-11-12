package leetcode.topinterview.tree;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.tree
 * @since : 2023/04/06
 */
public class TreeNode {

  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode() {
  }

  public TreeNode(int val) {
    this.val = val;
  }

  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
