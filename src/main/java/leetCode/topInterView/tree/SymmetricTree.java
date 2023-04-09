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

      leftFirstTraversal(root.left, lStack);
      rightFirstTraversal(root.right, rStack);

      return checkResult(lStack, rStack);
    }

    private void leftFirstTraversal(TreeNode left, Stack<Integer> lStack) {
      if (left == null) {
        lStack.push(null);
        return;
      }

      lStack.push(left.val);
      leftFirstTraversal(left.left, lStack);
      leftFirstTraversal(left.right, lStack);
    }

    private void rightFirstTraversal(TreeNode right, Stack<Integer> rStack) {
      if (right == null) {
        rStack.push(null);
        return;
      }

      rStack.push(right.val);
      rightFirstTraversal(right.right, rStack);
      rightFirstTraversal(right.left, rStack);
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

    private void printResult(Stack<Integer> lStack, Stack<Integer> rStack) {
      int sSize = lStack.size();
      for (int i = 0; i < sSize; i++) {
        Integer l = lStack.pop();
        Integer r = rStack.pop();
        System.out.println(i + " : [ l , r ]" + "[ " + l + " , " + r + " ]");
      }
    }
  }
}
