package leetCode.topInterView.Design;

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
      top.next = null;
      top.min = val;
      size++;
    } else {
      Node temp = new Node();
      temp.val = val;
      temp.next = top;
      temp.min = Math.min(val, top.min);
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

interface MinStackInterface {

  void push(int val);

  void pop();

  int top();

  int getMin();
}
