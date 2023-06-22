package leetCode.topInterView.BST;

import leetCode.topInterView.BST.KthSmallestElementBST.KthSmallestElementBSTInterface;
import leetCode.topInterView.tree.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.BST
 * @since : 2023/06/22
 */
public class KthSmallestElementBSTTest {

  @Test
  public void test_kthSmallest_1() {
    KthSmallestElementBSTInterface solution = KthSmallestElementBST.getSolution();
    TreeNode na = new TreeNode(1);
    TreeNode nb = new TreeNode(2);
    TreeNode nc = new TreeNode(3);
    TreeNode nd = new TreeNode(4);
    TreeNode ne = new TreeNode(5);
    nc.left = na;
    nc.right = nd;
    na.right = nb;
    int actual = solution.kthSmallest(nc, 3);
    Assert.assertEquals(3, actual);
  }

  @Test
  public void test_kthSmallest_2() {
    KthSmallestElementBSTInterface solution = KthSmallestElementBST.getSolution();
    TreeNode n1 = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(3);
    TreeNode n4 = new TreeNode(4);
    TreeNode n5 = new TreeNode(5);
    TreeNode n6 = new TreeNode(6);
    n5.left = n3;
    n5.right = n6;
    n3.right = n4;
    n3.left = n2;
    n2.left = n1;
    int actual = solution.kthSmallest(n5, 3);
    Assert.assertEquals(3, actual);
  }

  /*
      4
    /   \
   2     5
     \
      3
   */
  @Test
  public void test_kthSmallest_3() {
    KthSmallestElementBSTInterface solution = KthSmallestElementBST.getSolution();
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(3);
    TreeNode n4 = new TreeNode(4);
    TreeNode n5 = new TreeNode(5);
    n4.left = n2;
    n4.right = n5;
    n2.right = n3;
    int actual = solution.kthSmallest(n4, 1);
    Assert.assertEquals(2, actual);
  }
}