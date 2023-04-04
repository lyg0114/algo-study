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
    ListNode node6 = new ListNode(6);
    ListNode node7 = new ListNode(7);

    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;
    node6.next = node7;

  }
}

class RemoveNthNodeSolution {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    return null;
  }

}
