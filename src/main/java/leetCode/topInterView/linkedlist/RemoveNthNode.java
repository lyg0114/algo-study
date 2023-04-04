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
    solution.removeNthFromEnd(node1, 1);
    LinkedListUtils.showNodes(node1);
  }
}

class RemoveNthNodeSolution {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode reHead = head;
    ListNode start = head;
    if (head == null || head.next == null) {
      return null;
    }
    int totalIndex = 1;
    while (head.next != null) {
      totalIndex++;
      head = head.next;
    }
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
    } else {
      if (totalIndex > 2) {
        if (n == 1) {
          int index = 1;
          while ((totalIndex - n) != index) {
            start = start.next;
            index++;
          }
          start.next = null;
        } else {
          int index = 1;
          while ((totalIndex - n) + 1 != index) {
            start = start.next;
            index++;
          }
          start.val = start.next.val;
          start.next = start.next.next;
        }
      }
    }
    return reHead;
  }
}
