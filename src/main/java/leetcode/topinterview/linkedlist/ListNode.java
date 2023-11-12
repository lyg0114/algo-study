package leetcode.topinterview.linkedlist;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.linkedlist
 * @since : 2023/04/02
 */
public class ListNode {

  public int val;
  public ListNode next;

  public ListNode() {
  }

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}
