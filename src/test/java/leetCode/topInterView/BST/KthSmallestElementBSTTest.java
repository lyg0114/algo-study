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
    nc.left = na;
    nc.right = nd;
    na.right = nb;
    int actual = solution.kthSmallest(nc, 3);
    Assert.assertEquals(3, actual);
  }
}