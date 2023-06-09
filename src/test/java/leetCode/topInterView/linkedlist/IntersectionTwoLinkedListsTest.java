package leetCode.topInterView.linkedlist;

import static org.junit.Assert.*;

import java.util.Stack;
import leetCode.topInterView.linkedlist.IntersectionTwoLinkedLists.IntersectionTwoLinkedListsInterface;
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

  @Test
  public void test_getIntersectionNode_1() {
    ListNode A1 = new ListNode(4);
    ListNode A2 = new ListNode(1);
    A1.next = A2;

    ListNode B1 = new ListNode(5);
    ListNode B2 = new ListNode(6);
    ListNode B3 = new ListNode(1);
    B1.next = B2;
    B2.next = B3;

    ListNode C1 = new ListNode(8);
    ListNode C2 = new ListNode(4);
    ListNode C3 = new ListNode(5);
    A2.next = C1;
    B3.next = C1;
    C1.next = C2;
    C2.next = C3;

    IntersectionTwoLinkedListsInterface solution = IntersectionTwoLinkedLists.getSolution();
    ListNode intersectionNode = solution.getIntersectionNode(A1, B1);
    assertSame(intersectionNode, C1);
  }
}