package leetcode.topinterview.linkedlist;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView
 * @since : 2023/04/05
 */
public class MergeTwoSortedLists {

  public static void main(String[] args) {
    MergeTwoSortedListsInterface solution = getSolution();
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(4);
    n1.next = n2;
    n2.next = n3;

    ListNode e1 = new ListNode(2);
    ListNode e2 = new ListNode(3);
    ListNode e3 = new ListNode(4);
    e1.next = e2;
    e2.next = e3;
    ListNode nstart = solution.mergeTwoLists(n1, e1);

    while (nstart.next != null) {
      System.out.println("nstart.val = " + nstart.val);
      nstart = nstart.next;
    }
  }

  private static MergeTwoSortedListsInterface getSolution() {
    return new MergeTwoSortedListsSolutionV1();
  }

  public static class MergeTwoSortedListsSolutionV1 implements MergeTwoSortedListsInterface {

    @Override
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      if (list1 == null || list2 == null) {
        return null;
      }

      ListNode dummy = new ListNode();
      ListNode tail = dummy;

      while (list1 != null && list2 != null) {
        if (list1.val < list2.val) {
          tail.next = list1;
          list1 = list1.next;
        } else {
          tail.next = list2;
          list2 = list2.next;
        }
        tail = tail.next;
      }

      if (list1 == null) {
        tail.next = list2;
      } else {
        tail.next = list1;
      }

      return dummy.next;
    }
  }

  public static class MergeTwoSortedListsSolution2 implements MergeTwoSortedListsInterface {

    @Override
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      if (list1 == null || list2 == null) {
        return null;
      }

      ListNode dummy = new ListNode(0);
      ListNode tail = dummy;

      while (list1 != null && list2 != null) {
        if (list1.val < list2.val) {
          tail.next = list1;
          list1 = list1.next;
        } else {
          tail.next = list2;
          list2 = list2.next;
        }
        tail = tail.next;
      }

      if (list1 != null) {
        tail.next = list1;
      } else {
        tail.next = list2;
      }

      return dummy.next;
    }
  }

  public static class MergeTwoSortedListsSolution3 implements MergeTwoSortedListsInterface {

    @Override
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      if (list1 == null || list2 == null) {
        return null;
      }

      ListNode merged = new ListNode();
      ListNode head = merged;

      while (list1 != null && list2 != null) {
        int value;

        if (list1.val < list2.val) {
          value = list1.val;
          list1 = list1.next;
        } else {
          value = list2.val;
          list2 = list2.next;
        }

        merged.next = new ListNode(value, null);
        merged = merged.next;
      }

      if (list1 != null) {
        merged.next = list1;
      }

      if (list2 != null) {
        merged.next = list2;
      }

      head = head.next;
      System.gc();
      return head;
    }
  }

  interface MergeTwoSortedListsInterface {

    ListNode mergeTwoLists(ListNode list1, ListNode list2);
  }
}


