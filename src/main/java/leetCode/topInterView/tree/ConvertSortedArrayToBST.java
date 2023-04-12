package leetCode.topInterView.tree;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.tree
 * @since : 2023/04/12
 */
public class ConvertSortedArrayToBST {

  public static void main(String[] args) {
    SolutionInterface solution = getSolution();
    int[] nums = {1, 2, 3};
    TreeNode treeNode = solution.sortedArrayToBST(nums);
    solution.printNodes(null);
  }

  private static Solution getSolution() {
    return new Solution();
  }

  public interface SolutionInterface {

    TreeNode sortedArrayToBST(int[] nums);

    default void printNodes(TreeNode root) {
      // print BST
    }
  }

  public static class Solution implements SolutionInterface {

    public TreeNode sortedArrayToBST(int[] nums) {
      if (nums == null || nums.length == 0) {
        return null;
      }
      if (nums.length == 1) {
        return new TreeNode(nums[0]);
      }

      TreeNode root = new TreeNode(nums[0]);
      for (int i = 1; i < nums.length; i++) {
        makeBST(nums[i], root);
      }

      return null;
    }

    private void makeBST(int num, TreeNode node) {

    }

  }
}
