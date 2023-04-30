package leetCode.topInterView.Design;

import java.util.Stack;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Design
 * @url : https://leetcode.com/explore/featured/card/top-interview-questions-easy/98/design/562/
 * @since : 2023/04/29
 */
public class MinStack {

  public static void main(String[] args) {
    MinStackInterface solution = getSolution();
    solution.push(-2);
    solution.push(0);
    solution.push(-3);
    System.out.println("solution.getMin() = " + solution.getMin());
    solution.pop();
    System.out.println("solution.top() = " + solution.top());
    System.out.println("solution.getMin() = " + solution.getMin());
  }

  private static MinStackInterface getSolution() {
    return new MinStackSolution();
  }
}

class MinStackSolution implements MinStackInterface {

  private static class Node {

    int val;
    Node next;
    int min;
  }

  Node top;
  int size;

  public MinStackSolution() {
    size = 0;
  }

  @Override
  public void push(int val) {
    if (size == 0) {
      top = new Node();
      top.val = val;
      top.min = val;
      top.next = null;
      size++;
    } else {
      Node temp = new Node();
      temp.val = val;
      temp.min = Math.min(top.min, val);
      temp.next = top;
      top = temp;
      size++;
    }
  }

  @Override
  public void pop() {
    top = top.next;
    size--;
  }

  @Override
  public int top() {
    return top.val;
  }

  @Override
  public int getMin() {
    return top.min;
  }
}

class MinStackSolutionV2 implements MinStackInterface {

  private Stack<Integer> stack;
  private Stack<Integer> minStack;

  public MinStackSolutionV2() {
    stack = new Stack<>();
    minStack = new Stack<>();
  }

  public void push(int val) {
    stack.push(val);
    if (minStack.isEmpty() || val <= minStack.peek()) {
      minStack.push(val);
    }
  }

  public void pop() {
    if (stack.peek().equals(minStack.peek())) {
      minStack.pop();
    }
    stack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }
}

class MinStackGround implements MinStackInterface {

  @Override
  public void push(int val) {

  }

  @Override
  public void pop() {

  }

  @Override
  public int top() {
    return 0;
  }

  @Override
  public int getMin() {
    return 0;
  }
}

interface MinStackInterface {

  void push(int val);

  void pop();

  int top();

  int getMin();
}
