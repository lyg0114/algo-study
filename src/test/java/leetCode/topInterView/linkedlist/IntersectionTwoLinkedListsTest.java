package leetCode.topInterView.linkedlist;

import static org.junit.Assert.*;

import java.util.Stack;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.linkedlist
 * @since : 2023/06/09
 */
public class IntersectionTwoLinkedListsTest {

  @Test
  public void test_stack() {
    ListNode n1 = new ListNode(1);

    Stack<ListNode> stk1 = new Stack<>();
    Stack<ListNode> stk2 = new Stack<>();

    stk1.push(n1);
    stk2.push(n1);

    ListNode pop1 = stk1.pop();
    ListNode pop2 = stk2.pop();

    assertSame(pop1, pop2);
  }
}