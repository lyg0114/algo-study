package leetCode.topInterView.linkedlist;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.linkedlist
 * @url : https://leetcode.com/explore/featured/card/top-interview-questions-easy/93/linked-list/603/
 * @since : 2023/04/04
 */
public class RemoveNthNode {

  public static void main(String[] args) {
    RemoveNthNodeSolution solution = new RemoveNthNodeSolution();
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);

    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;

    LinkedListUtils.showNodes(node1);
    solution.removeNthFromEnd(node1, 2);
    LinkedListUtils.showNodes(node1);
  }
}

class RemoveNthNodeSolution {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null || head.next == null) {
      return null;
    }
    ListNode start = head;
    int totalIndex = 1;
    while (start.next != null) {
      totalIndex++;
      start = start.next;
    }
    start = head;
    if (totalIndex < n) {
      return null;
    }

    if (totalIndex == 2) {
      if (n == 1) {
        start.next = null;
      }
      if (n == 2) {
        start.val = start.next.val;
        start.next = null;
      }
    }

    if (totalIndex > 2) {
      int index = 1;
      if (n == 1) {
        while ((totalIndex - n) != index) {
          start = start.next;
          index++;
        }
        start.next = null;
      } else {
        while ((totalIndex - n) + 1 != index) {
          start = start.next;
          index++;
        }
        start.val = start.next.val;
        start.next = start.next.next;
      }
    }
    return head;
  }
}
