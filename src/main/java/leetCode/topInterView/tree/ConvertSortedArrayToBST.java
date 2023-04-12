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
  }

  private static SolutionInterface getSolution() {
    return new Solution1();
  }


  public static class Solution1 implements SolutionInterface {

    public TreeNode sortedArrayToBST(int[] nums) {
      if (nums == null || nums.length == 0) {
        return null;
      }
      return constructBST(nums, 0, nums.length - 1);
    }

    private TreeNode constructBST(int[] nums, int start, int end) {
      if (start > end) {
        return null;
      }
      int mid = start + (end - start) / 2;
      TreeNode root = new TreeNode(nums[mid]);
      root.left = constructBST(nums, start, mid - 1);
      root.right = constructBST(nums, mid + 1, end);
      return root;
    }
  }

  public interface SolutionInterface {

    TreeNode sortedArrayToBST(int[] nums);

    default void printNodes(TreeNode root) {
      // print BST
    }
  }
}
