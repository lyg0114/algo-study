package leetCode.topInterView.tree;

import java.util.LinkedList;
import java.util.Queue;
import leetCode.topInterView.tree.BinaryTreeLevelOrderTraversal.BinaryTreeLevelOrderTraversalInterface;
import leetCode.topInterView.tree.BinaryTreeLevelOrderTraversal.BinaryTreeLevelOrderTraversalSolution;
import leetCode.topInterView.tree.BinaryTreeLevelOrderTraversal.BinaryTreeLevelOrderTraversalSolution3;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.tree
 * @since : 2023/04/11
 */
public class BinaryTreeLevelOrderTraversalTest {

  private BinaryTreeLevelOrderTraversalInterface getSolution() {
//    return new BinaryTreeLevelOrderTraversal.BinaryTreeLevelOrderTraversalSolution2();
    return new BinaryTreeLevelOrderTraversalSolution3();
  }

  /*
       2
      / \
     1   5
        / \
       4   6
  */
  @Test
  public void testCaseTrue1() {
    BinaryTreeLevelOrderTraversalInterface solution = getSolution();
    TreeNode n1 = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(5);
    TreeNode n4 = new TreeNode(4);
    TreeNode n5 = new TreeNode(6);
    n2.left = n1;
    n2.right = n3;
    n3.left = n4;
    n3.right = n5;
    System.out.println(solution.levelOrder(n2));
  }

  /*
       2
      / \
     1   5
    /     \
   4       6
  */
  @Test
  public void testCaseTrue2() {
    BinaryTreeLevelOrderTraversalInterface solution = getSolution();
    TreeNode n1 = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    TreeNode n4 = new TreeNode(4);
    TreeNode n5 = new TreeNode(5);
    TreeNode n6 = new TreeNode(6);
    n2.left = n1;
    n2.right = n5;
    n1.left = n4;
    n5.right = n6;
    System.out.println(solution.levelOrder(n2));
  }

  /*
          2
        /    \
      1       5
     / \     / \
    7  8    4   6
  */
  @Test
  public void testCaseTrue3() {
    BinaryTreeLevelOrderTraversalInterface solution = getSolution();
    TreeNode n2 = new TreeNode(2);
    TreeNode n1 = new TreeNode(1);
    TreeNode n5 = new TreeNode(5);
    TreeNode n7 = new TreeNode(7);
    TreeNode n8 = new TreeNode(8);
    TreeNode n4 = new TreeNode(4);
    TreeNode n6 = new TreeNode(6);

    n2.left = n1;
    n2.right = n5;
    n1.left = n7;
    n1.right = n8;
    n5.left = n4;
    n5.right = n6;

    System.out.println(solution.levelOrder(n2));
  }

  @Test
  public void offerQueue() {
    Queue<Integer> roots = new LinkedList<>();
    roots.offer(3);
    roots.offer(2);
    roots.offer(6);
    roots.offer(4);
    System.out.println("roots = " + roots);
    Integer poll = roots.poll();
    System.out.println("poll = " + poll);
    System.out.println("roots = " + roots);
  }

  @Test
  public void addQueue() {
    Queue<Integer> roots = new LinkedList<>();
    roots.add(3);
    roots.add(2);
    roots.add(6);
    roots.add(4);
    System.out.println("roots = " + roots);
    Integer peek = roots.peek();
    System.out.println("peek = " + peek);
    System.out.println("roots = " + roots);
  }

  @Test
  public void mergeQueue() {
    Queue<Integer> queue1 = new LinkedList<>();
    queue1.add(3);
    queue1.add(2);
    queue1.add(6);
    queue1.add(4);
    System.out.println("queue1 = " + queue1);

    Queue<Integer> queue2 = new LinkedList<>();
    queue2.add(6);
    queue2.add(3);
    queue2.add(5);
    queue2.add(1);
    System.out.println("queue2 = " + queue2);

    queue1.addAll(queue2);
    System.out.println("queue1 = " + queue1);

    queue1.addAll(queue2);
    System.out.println("queue2 = " + queue2);
  }


}