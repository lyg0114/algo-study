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
    TreeNode root = new TreeNode(1);
    TreeNode lNode2 = new TreeNode(2);
    TreeNode lNode3 = new TreeNode(3);
    TreeNode lNode4 = new TreeNode(4);
    TreeNode rNode2 = new TreeNode(2);
    TreeNode rNode3 = new TreeNode(3);
    TreeNode rNode4 = new TreeNode(4);

    root.left = lNode2;
    lNode2.left = lNode3;
    lNode2.right = lNode4;
    root.right = rNode2;
    rNode2.left = rNode4;
    rNode2.right = rNode3;

    SymmetricTreeInterface solution = getSolution();
  }

  private static SymmetricTreeInterface getSolution() {
    return new SymmetricTreeSolution();
  }

  private static class SymmetricTreeSolution2 implements SymmetricTreeInterface {
    public boolean isSymmetric(TreeNode root) {
      return false;
    }
  }

  private static class SymmetricTreeSolution implements SymmetricTreeInterface {

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

    private void printResult(Stack<Integer> lStack, Stack<Integer> rStack) {
      while (!lStack.isEmpty()) {
        System.out.println(lStack.pop());
      }
      while (!rStack.isEmpty()) {
        System.out.println(rStack.pop());
      }
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
      while (lStack.size() > 0) {
        Integer lPop = lStack.pop();
        Integer rPop = rStack.pop();
        if (lPop != null && rPop != null) {
          if (!lPop.equals(rPop)) {
            return false;
          }
        } else if (lPop == null && rPop == null) {
        } else {
          return false;
        }
      }
      return true;
    }
  }

  private interface SymmetricTreeInterface {
    boolean isSymmetric(TreeNode root);
  }
}
