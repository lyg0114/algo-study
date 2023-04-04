package leetCode.topInterView.linkedlist.nthnode;

import leetCode.topInterView.linkedlist.LinkedListUtils;
import leetCode.topInterView.linkedlist.ListNode;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.linkedlist
 * @url : https://leetcode.com/explore/featured/card/top-interview-questions-easy/93/linked-list/603/
 * @since : 2023/04/04
 */
public class RemoveNthNode {

  public static void main(String[] args) {
    RemoveNthNodeInterface solution = getRemoveNthNodeInterface();
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

  private static RemoveNthNodeInterface getRemoveNthNodeInterface() {
    return new RemoveNthNodeSolution();
  }
}

