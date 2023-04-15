package leetCode.topInterView.tree;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.tree
 * @url : https://leetcode.com/explore/featured/card/top-interview-questions-easy/94/trees/625/
 * @since : 2023/04/06
 */
public class ValidateBinarySearchTree {
  /*
       3
      / \
     1   5
        / \
       2   6
  */
  public static void main(String[] args) {
    ValidateBinarySearchTreeInter solution = new ValidateBinarySearchTreeSolution();

    TreeNode n3 = new TreeNode(3);
    TreeNode n1 = new TreeNode(1);
    TreeNode n5 = new TreeNode(5);
    TreeNode n2 = new TreeNode(2);
    TreeNode n6 = new TreeNode(6);
    n3.left = n1;
    n3.right = n5;
    n5.left = n2;
    n5.right = n6;
  }
}

//  노드의 왼쪽 서브트리에는 그 노드의 값보다 작은 값들을 지닌 노드들로 이루어져 있다.
//  노드의 오른쪽 서브트리에는 그 노드의 값보다 큰 값들을 지닌 노드들로 이루어져 있다.
class ValidateBinarySearchTreeSolution implements ValidateBinarySearchTreeInter {

  @Override
  public boolean isValidBST(TreeNode root) {
    return isValidBST(root, null, null);
  }

  private boolean isValidBST(TreeNode node, Integer minLimit, Integer maxLimit) {
    if (node == null) {
      return true;
    }
    // 이진검색 트리의 조건에 위배되는 경우 false를 반환한다.
    if ((minLimit != null && node.val <= minLimit) || (maxLimit != null && node.val >= maxLimit)) {
      return false;
    }
    boolean left = isValidBST(node.left, minLimit, node.val); //렙민벨
    boolean right = isValidBST(node.right, node.val, maxLimit); //뢋벨맥
    return left && right;
  }
}

class ValidateBinarySearchTreeSolution2 implements ValidateBinarySearchTreeInter {

  @Override
  public boolean isValidBST(TreeNode root) {
    return isValidBST(root, null, null);
  }

  private boolean isValidBST(TreeNode node, Integer minLimit, Integer maxLimit) {
    if(node == null)
      return true;

    boolean left = isValidBST(node.left, minLimit, node.val);
    boolean right = isValidBST(node.right, node.val, maxLimit);
    return left && right;
  }
}

interface ValidateBinarySearchTreeInter {
  boolean isValidBST(TreeNode root);
}
