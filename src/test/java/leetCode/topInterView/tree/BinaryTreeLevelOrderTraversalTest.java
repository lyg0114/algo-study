package leetCode.topInterView.tree;

import static org.junit.Assert.*;

import leetCode.topInterView.tree.BinaryTreeLevelOrderTraversal.SolInterface;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.tree
 * @since : 2023/04/11
 */
public class BinaryTreeLevelOrderTraversalTest {

  private SolInterface getSolution() {
    return new BinaryTreeLevelOrderTraversal.Solution2();
  }

  /*
       2
      / \
     1   5
        / \
       4   6
  */
  @Test
  public void testCaseTrue1() {
    SolInterface solution = getSolution();
    TreeNode n1 = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(5);
    TreeNode n4 = new TreeNode(4);
    TreeNode n5 = new TreeNode(6);
    n2.left = n1;
    n2.right = n3;
    n3.left = n4;
    n3.right = n5;
    System.out.println(solution.levelOrder(n2));
  }

}