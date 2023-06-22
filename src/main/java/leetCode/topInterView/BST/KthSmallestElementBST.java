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
    int i = solution.kthSmallest(nc, 1);
    System.out.println("i = " + i);
  }

  private static KthSmallestElementBSTInterface getSolution() {
    return new KthSmallestElementBSTV2();
  }

  public static class KthSmallestElementBSTV2 implements KthSmallestElementBSTInterface {

    @Override
    public int kthSmallest(TreeNode root, int k) {
      return 0;
    }
  }

  public interface KthSmallestElementBSTInterface {

    int kthSmallest(TreeNode root, int k);
  }
}
