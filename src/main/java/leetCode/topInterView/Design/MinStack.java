package leetCode.topInterView.Design;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Design
 * @url : https://leetcode.com/explore/featured/card/top-interview-questions-easy/98/design/562/
 * @since : 2023/04/29
 */
public class MinStack {

  public static void main(String[] args) {

  }
}

class MinStackSolution implements MinStackInterface {

  private int min;
  private int top;
  private int[] minStack = new int[30000];

  public MinStackSolution() {
  }

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
