package leetCode.topInterView.BST;

import leetCode.topInterView.tree.TreeNode;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.BST
 * @since : 2023/06/22
 */
public class KthSmallestElementBST {

  public static void main(String[] args) {
    TreeNode na = new TreeNode(1);
    TreeNode nb = new TreeNode(2);
    TreeNode nc = new TreeNode(3);
    TreeNode nd = new TreeNode(4);
    nc.left = na;
    nc.right = nd;
    na.right = nb;
    KthSmallestElementBSTInterface solution = getSolution();
    int i = solution.kthSmallest(nc, 3);
    System.out.println("i = " + i);
  }

  private static KthSmallestElementBSTInterface getSolution() {
    return new KthSmallestElementBSTV1();
  }

  public static class KthSmallestElementBSTV1 implements KthSmallestElementBSTInterface {

    private int res = 0;
    private int cur = 0;
    private boolean status = true;

    @Override
    public int kthSmallest(TreeNode root, int k) {
      traverse(root, k);
      return res;
    }

    public void traverse(TreeNode node, int k) {
      if (node == null) {
        return;
      }
      if (status) {
        traverse(node.left, k);
      }
      if (k == (++cur)) {
        status = false;
        res = cur;
      }
      if (status) {
        traverse(node.right, k);
      }
    }
  }

  public interface KthSmallestElementBSTInterface {

    int kthSmallest(TreeNode root, int k);
  }
}
