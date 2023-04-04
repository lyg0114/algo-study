package leetCode.topInterView.linkedlist.nthnode;

import leetCode.topInterView.linkedlist.ListNode;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.linkedlist.nthnode
 * @since : 2023/04/04
 */
class RemoveNthNodeSolution implements RemoveNthNodeInterface {

  @Override
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
