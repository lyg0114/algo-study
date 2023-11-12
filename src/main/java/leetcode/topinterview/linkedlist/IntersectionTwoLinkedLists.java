package leetcode.topinterview.linkedlist;

import java.util.Stack;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.linkedlist
 * @since : 2023/06/09
 */
public class IntersectionTwoLinkedLists {

  public static void main(String[] args) {
    IntersectionTwoLinkedListsInterface solution = getSolution();
  }

  public static IntersectionTwoLinkedListsInterface getSolution() {
    return new IntersectionTwoLinkedListsSolutionV2();
  }

  public static class IntersectionTwoLinkedListsSolutionV2 implements
      IntersectionTwoLinkedListsInterface {

    @Override
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      if (headA == null || headB == null) {
        return null;
      }

      ListNode a = headA;
      ListNode b = headB;
      while (a != b) {
        a = a == null ? headB : a.next;
        b = b == null ? headA : b.next;
      }
      return a;
    }
  }

  public static class IntersectionTwoLinkedListsSolutionV1 implements
      IntersectionTwoLinkedListsInterface {

    @Override
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      if (headA == null || headB == null) {
        return new ListNode(0);
      }
      Stack<ListNode> stk1 = new Stack<>();
      Stack<ListNode> stk2 = new Stack<>();
      while (headA != null && headB != null) {
        stk1.push(headA);
        stk2.push(headB);
        headA = headA.next;
        headB = headB.next;
      }
      while (headA != null) {
        stk1.push(headA);
        headA = headA.next;
      }
      while (headB != null) {
        stk2.push(headB);
        headB = headB.next;
      }

      while (stk1.peek() == stk2.peek()) {
        stk1.pop();
        stk2.pop();
      }
      return stk1.pop().next;
    }
  }

  public interface IntersectionTwoLinkedListsInterface {

    ListNode getIntersectionNode(ListNode headA, ListNode headB);
  }
}

