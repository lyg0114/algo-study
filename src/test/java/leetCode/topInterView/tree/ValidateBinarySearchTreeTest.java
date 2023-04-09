package leetCode.topInterView.tree;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.tree
 * @since : 2023/04/06
 */
public class ValidateBinarySearchTreeTest {

  /*
       2
      / \
     1   5
        / \
       4   6
  */
  @Test
  public void testCaseTrue1() {
    ValidateBinarySearchTreeInter solution = getSolution();
    TreeNode n1 = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(5);
    TreeNode n4 = new TreeNode(4);
    TreeNode n5 = new TreeNode(6);
    n2.left = n1;
    n2.right = n3;
    n3.left = n4;
    n3.right = n5;
    assertTrue(solution.isValidBST(n2));
  }


  /*
        2
      /   \
     1     5
         /   \
        4     7
       /     / \
      3     6   8
                 \
                  9
  */
  @Test
  public void testCaseTrue2() {
    ValidateBinarySearchTreeInter solution = getSolution();
    TreeNode n1 = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(3);
    TreeNode n4 = new TreeNode(4);
    TreeNode n5 = new TreeNode(5);
    TreeNode n6 = new TreeNode(6);
    TreeNode n7 = new TreeNode(7);
    TreeNode n8 = new TreeNode(8);
    TreeNode n9 = new TreeNode(9);

    n2.left = n1;
    n2.right = n5;
    n5.left = n4;
    n5.right = n7;
    n4.left = n3;
    n7.left = n6;
    n7.right = n8;
    n8.right = n9;

    assertTrue(solution.isValidBST(n2));
  }

  /*
       5
      / \
     1   4
        / \
       3   6
  */
  @Test
  public void testCaseFalse1() {
    ValidateBinarySearchTreeInter solution = getSolution();
    TreeNode node1 = new TreeNode(1);
    TreeNode node5 = new TreeNode(5);
    TreeNode node4 = new TreeNode(4);
    TreeNode node3 = new TreeNode(3);
    TreeNode node6 = new TreeNode(6);

    node5.left = node1;
    node5.right = node4;
    node4.left = node3;
    node4.right = node6;
    assertFalse(solution.isValidBST(node5));
  }


  /*
       3
      / \
     1   5
        / \
       2   6
  */
  @Test
  public void testCaseFalse2() {
    ValidateBinarySearchTreeInter solution = getSolution();
    TreeNode n3 = new TreeNode(3);
    TreeNode n1 = new TreeNode(1);
    TreeNode n5 = new TreeNode(5);
    TreeNode n2 = new TreeNode(2);
    TreeNode n6 = new TreeNode(6);
    n3.left = n1;
    n3.right = n5;
    n5.left = n2;
    n5.right = n6;
    assertFalse(solution.isValidBST(n3));
  }


  private ValidateBinarySearchTreeInter getSolution() {
    return new ValidateBinarySearchTreeSolution();
  }
}