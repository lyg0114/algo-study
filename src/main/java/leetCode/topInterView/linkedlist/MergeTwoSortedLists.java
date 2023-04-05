package leetCode.topInterView.linkedlist;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView
 * @since : 2023/04/05
 */
public class MergeTwoSortedLists {

  public static void main(String[] args) {
    MergeTwoSortedListsInterface solution = new MergeTwoSortedListsSolution();
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(4);
    n1.next = n2;
    n2.next = n3;

    ListNode e1 = new ListNode(3);
    ListNode e2 = new ListNode(4);
    ListNode e3 = new ListNode(5);
    e1.next = e2;
    e2.next = e3;
    ListNode nstart = solution.mergeTwoLists(n1, e1);
    while (nstart.next != null) {
      System.out.println("nstart.val = " + nstart.val);
      nstart = nstart.next;
    }
  }
}

class MergeTwoSortedListsSolution implements MergeTwoSortedListsInterface {

  @Override
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 == null) {
      return list2;
    }
    if (list2 == null) {
      return list1;
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


interface MergeTwoSortedListsInterface {

  ListNode mergeTwoLists(ListNode list1, ListNode list2);
}

