package leetCode.topInterView.linkedlist;

import java.util.Stack;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.linkedlist
 * @url : https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/772/
 * @since : 2023/04/05
 */
public class PalindromeLinkedList {

  public static void main(String[] args) {
    PalindromeLinkedListInterface solution = getSolution();
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(1);
    ListNode n3 = new ListNode(2);
    ListNode n4 = new ListNode(2);
    ListNode n5 = new ListNode(1);
    ListNode n6 = new ListNode(1);

    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    n5.next = n6;

    System.out.println(solution.isPalindrome(n1));
  }

  private static PalindromeLinkedListInterface getSolution() {
    return new PalindromeLinkedListSolution2();
  }
}

class PalindromeLinkedListSolution implements PalindromeLinkedListInterface {

  @Override
  public boolean isPalindrome(ListNode head) {
    if (head == null) {
      return false;
    }

    ListNode tmp = head;
    Stack<Integer> stack = new Stack<>();
    while (tmp != null) {
      stack.push(tmp.val);
      tmp = tmp.next;
    }

    while (head != null) {
      if (head.val != stack.pop()) {
        return false;
      }
      head = head.next;
    }

    return true;
  }
}

class PalindromeLinkedListSolution2 implements PalindromeLinkedListInterface {

  @Override
  public boolean isPalindrome(ListNode head) {
    ListNode slow = head, fast = head, prev, temp;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    prev = slow;
    slow = slow.next;
    prev.next = null;
    while (slow != null) {
      temp = slow.next;
      slow.next = prev;
      prev = slow;
      slow = temp;
    }
    fast = head;
    slow = prev;
    while (slow != null) {
      if (fast.val != slow.val) {
        return false;
      }
      fast = fast.next;
      slow = slow.next;
    }
    return true;
  }
}

interface PalindromeLinkedListInterface {

  boolean isPalindrome(ListNode head);
}
