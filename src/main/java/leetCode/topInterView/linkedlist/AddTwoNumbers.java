package leetCode.topInterView.linkedlist;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.others
 * @since : 2023/05/17
 */
public class AddTwoNumbers {

  public static void main(String[] args) {
  }

  private static AddTwoNumbersInterface getSolution() {
    return new AddTwoNumbersSolution();
  }

  public static class AddTwoNumbersSolution implements AddTwoNumbersInterface {

    @Override
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      if (l1 == null && l2 == null) {
        return null;
      }
      if (l1 != null && l2 == null) {
        return l1;
      }
      if (l1 == null && l2 != null) {
        return l2;
      }

      if (l1.next == null && l2.next == null) {
        int tmp = l1.val + l2.val;
        if (tmp >= 10) {
          ListNode listNode = new ListNode(tmp - 10);
          ListNode listNode1 = new ListNode(1);
          listNode.next = listNode1;
          return listNode;
        } else {
          return new ListNode(tmp);
        }
      }

      int overSum = 0;
      int tmpResult = 0;
      ListNode start = null;
      ListNode current = null;
      while (l1 != null && l2 != null) {
        if (overSum == 10) {
          tmpResult = l1.val + l2.val + 1;
          overSum = 0;
        } else {
          tmpResult = l1.val + l2.val;
        }

        if (tmpResult >= 10) {
          overSum = 10;
          tmpResult -= 10;
        }

        ListNode tmp = new ListNode(tmpResult);
        if (start == null) {
          start = tmp;
          current = tmp;
        }

        if (l1.next == null && l2.next != null) {
          l1.next = new ListNode(0);
          l1 = l1.next;
          l2 = l2.next;
        } else if (l1.next != null && l2.next == null) {
          l1 = l1.next;
          l2.next = new ListNode(0);
          l2 = l2.next;
        } else {
          l1 = l1.next;
          l2 = l2.next;
        }
        current.next = tmp;
        current = current.next;
      }

      if (overSum == 10) {
        current.next = new ListNode(1);
        current = current.next;
      }

      return start;
    }
  }

  interface AddTwoNumbersInterface {

    ListNode addTwoNumbers(ListNode l1, ListNode l2);
  }
}

