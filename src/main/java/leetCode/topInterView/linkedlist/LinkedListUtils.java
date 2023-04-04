package leetCode.topInterView.linkedlist;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.linkedlist
 * @since : 2023/04/04
 */
public class LinkedListUtils {

  public static void showNodes(ListNode head) {
    while (head != null) {
      System.out.print(head.val + " ");
      head = head.next;
    }
    System.out.println("");
  }
}
