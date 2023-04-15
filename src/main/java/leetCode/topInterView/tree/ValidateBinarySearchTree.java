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


//  노드의 왼쪽 서브트리에는 그 노드의 값보다 작은 값들을 지닌 노드들로 이루어져 있다.
//  노드의 오른쪽 서브트리에는 그 노드의 값보다 큰 값들을 지닌 노드들로 이루어져 있다.
class ValidateBinarySearchTreeSolution implements ValidateBinarySearchTreeInter {

  @Override
  public boolean isValidBST(TreeNode root) {
    return helper(root, null, null);
  }

  private boolean helper(TreeNode node, Integer minLimit, Integer maxLimit) {
    if (node == null) {
      return true;
    }
    if ((minLimit != null && node.val <= minLimit) || (maxLimit != null && node.val >= maxLimit)) {
      return false;
    }
    boolean left = helper(node.left, minLimit, node.val);
    boolean right = helper(node.right, node.val, maxLimit);
    return left && right;
  }
}

interface ValidateBinarySearchTreeInter {

  boolean isValidBST(TreeNode root);
}
