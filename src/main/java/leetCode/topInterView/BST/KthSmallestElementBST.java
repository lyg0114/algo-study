package leetCode.topInterView.BST;

import leetCode.topInterView.tree.TreeNode;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.BST
 * @since : 2023/06/22
 */
public class KthSmallestElementBST {

  public static void main(String[] args) {
    KthSmallestElementBSTInterface solution = getSolution();
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
