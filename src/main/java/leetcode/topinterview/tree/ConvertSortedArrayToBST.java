package leetcode.topinterview.tree;

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

  public static class Solution1AddComment implements SolutionInterface {
    /*
     - This method takes in an array of integers representing a sorted sequence.
     - It returns a binary search tree (BST) where the root is the middle value of the array.
     - The left and right subtrees are the BSTs constructed from the left and right subarrays respectively.
    */
    public TreeNode sortedArrayToBST(int[] nums) {
      //  - Check if the input array is null or empty. If so, return null. 10
      if (nums == null || nums.length == 0) {
        return null;
      }
      // - Otherwise, call the helper method to construct the BST. 10
      /*
       - I am going to declare a method named constructBST
            that takes an array of integers and two integer values as arguments.
       */
      return constructBST(nums, 0, nums.length - 1);
    }

    /*
     - This is a recursive helper method that constructs a BST from a given subarray of nums[start...end]. 10
     - It works by recursively dividing the subarray in halves,
       setting the middle element as the root of the subtree,
       and recursively constructing the left and right subtrees. 10
     */
    private TreeNode constructBST(int[] nums, int start, int end) {
      // If the start index is greater than the end index, the subarray is empty 10
      // so return null to indicate an empty subtree. 10
      if (start > end) {
        return null;
      }
      // Calculate the middle index of the subarray. 3
      int mid = start + (end - start) / 2;
      // Create a new TreeNode with the middle value as its value.
      TreeNode root = new TreeNode(nums[mid]);
      // Recursively construct the left subtree with the left subarray
      // (nums[start...mid-1]).
      root.left = constructBST(nums, start, mid - 1);
      // Recursively construct the right subtree with the right subarray
      // (nums[mid+1...end]).
      root.right = constructBST(nums, mid + 1, end);
      // Return the root of the subtree.
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
