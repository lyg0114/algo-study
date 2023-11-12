package leetcode.topinterview.linkedlist;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.linkedlist
 * @url : https://leetcode.com/explore/featured/card/top-interview-questions-easy/93/linked-list/560/
 * @since : 2023/04/05
 */
public class ReverseLinkedList {

  public static void main(String[] args) {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;

    ReverseLinkedListInterface solution = getSolution();
    ListNode rNode = solution.reverseList(node1);
    while (rNode != null) {
      System.out.println(rNode.val + " ");
      rNode = rNode.next;
    }
  }

  public static ReverseLinkedListInterface getSolution() {
    return new ReverseLinkedListSolutionV1();
  }

  public static class ReverseLinkedListSolutionV3 implements ReverseLinkedListInterface {

    @Override
    public ListNode reverseList(ListNode head) {
      ListNode prev = null;
      ListNode curr = head;
      while (curr != null) {
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
      }
      System.gc();
      return prev;
    }
  }

  public static class ReverseLinkedListSolutionV2 implements ReverseLinkedListInterface {
    @Override
    public ListNode reverseList(ListNode head) {
      if (head == null) {
        return null;
      }
      if (head.next == null) {
        return head;
      }

      ListNode before = head;
      ListNode after = head.next;
      ListNode rHead = null;
      boolean isFirst = true;
      while (head.next != null) {
        before = head;
        after = head.next;
        while (after.next != null) {
          before = after;
          after = after.next;
        }
        if (isFirst) {
          rHead = after;
          isFirst = false;
        }
        after.next = before;
        before.next = null;
      }
      return rHead;
    }
  }

  public static class ReverseLinkedListSolutionV1 implements ReverseLinkedListInterface {
    @Override
    public ListNode reverseList(ListNode head) {
      ListNode curr = head;
      ListNode prev = null;
      ListNode next;

      while (curr != null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
      }
      return prev;
    }
  }

  public interface ReverseLinkedListInterface {

    ListNode reverseList(ListNode head);
  }
}


