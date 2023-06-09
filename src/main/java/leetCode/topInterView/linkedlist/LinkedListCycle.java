package leetCode.topInterView.linkedlist;

import java.util.HashSet;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.linkedlist
 * @since : 2023/04/05
 */
public class LinkedListCycle {

  public static void main(String[] args) {
    LinkedListCycleInterface solution = new LinkedListCycleSolution();
    ListNode node1 = new ListNode(3);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(0);
    ListNode node4 = new ListNode(-4);

    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node1;

    System.out.println(solution.hasCycle(node1));
  }

  public static class LinkedListCycleSolution implements LinkedListCycleInterface {

    @Override
    public boolean hasCycle(ListNode head) {
      if (head == null) {
        return false;
      }

      HashSet<ListNode> set = new HashSet<>();
      while (head.next != null) {
        if (set.contains(head)) {
          return true;
        }
        set.add(head);
        head = head.next;
      }
      return false;
    }
  }

  public static class LinkedListCycleSolution2 implements LinkedListCycleInterface {

    @Override
    public boolean hasCycle(ListNode head) {
      if (head == null) {
        return false;

      }
      ListNode slow = head;
      ListNode fast = head.next;

      while (fast != null && fast.next != null) {
        if (slow == fast) {
          return true;
        }
        slow = slow.next;
        fast = fast.next.next;
      }

      return false;
    }
  }

  interface LinkedListCycleInterface {

    boolean hasCycle(ListNode head);
  }
}


