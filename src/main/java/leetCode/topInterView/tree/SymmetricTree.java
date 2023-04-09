package leetCode.topInterView.tree;

import java.util.Stack;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.tree
 * @url :https://leetcode.com/explore/featured/card/top-interview-questions-easy/94/trees/627/
 * @since : 2023/04/09
 */
public class SymmetricTree {

  public static void main(String[] args) {

  }

  private static class SymmetricTreeSolution {

    public boolean isSymmetric(TreeNode root) {
      if (root == null) {
        return false;
      }

      Stack<Integer> lStack = new Stack<>();
      Stack<Integer> rStack = new Stack<>();

      leftTraversal(root.left, lStack);
      rightTraversal(root.right, rStack);

      return checkResult(lStack, rStack);
    }

    private boolean checkResult(Stack<Integer> lStack, Stack<Integer> rStack) {
      if (lStack.size() != rStack.size()) {
        return false;
      }
      int sSize = lStack.size();
      for (int i = 0; i < sSize; i++) {
        Integer l = lStack.pop();
        Integer r = rStack.pop();
        if (!l.equals(r)) {
          return false;
        }
      }

      return true;
    }

    private void rightTraversal(TreeNode right, Stack<Integer> rStack) {

    }

    private void leftTraversal(TreeNode left, Stack<Integer> lStack) {

    }


  }
}
