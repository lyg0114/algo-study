package leetcode.topinterview.linkedlist;

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
    return new PalindromeLinkedListSolutionV2();
  }

  public static class PalindromeLinkedListSolutionV2 implements PalindromeLinkedListInterface {

    @Override
    public boolean isPalindrome(ListNode head) {
      ListNode slow = head, fast = head, prev, temp;  // 두 개의 포인터와 prev, temp 변수를 선언합니다. slow와 fast 포인터는 head에서 시작합니다.

      // fast가 null이 아니고 fast.next가 null이 아닐 때까지 반복합니다. fast는 한 번에 두 노드씩 이동합니다.
      while (fast != null && fast.next != null) {
        slow = slow.next;  // slow 포인터는 한 번에 한 노드씩 이동합니다.
        fast = fast.next.next;  // fast 포인터는 한 번에 두 노드씩 이동합니다.
      }

      prev = slow;  // prev 변수에 slow 포인터가 가리키는 노드 이전의 노드를 저장합니다.
      slow = slow.next;  // slow 포인터를 중간 지점 바로 다음 노드로 이동합니다.
      prev.next = null;  // prev 노드를 null로 연결하여 중간 지점 이전과 이후의 노드들을 끊어줍니다.

      while (slow != null) {  // slow 포인터가 null이 아닐 때까지 반복합니다.
        temp = slow.next;  // temp 변수에 slow 포인터가 가리키는 다음 노드를 저장합니다.
        slow.next = prev;  // slow 포인터가 가리키는 노드의 다음 노드를 prev 노드로 연결합니다.
        prev = slow;  // prev 노드를 slow 포인터가 가리키는 노드로 변경합니다.
        slow = temp;  // slow 포인터를 temp 변수에 저장된 다음 노드로 이동합니다.
      }

      fast = head;  // fast 포인터를 다시 head에서 시작하도록 설정합니다.
      slow = prev;  // slow 포인터는 prev 변수에 저장된 역순으로 연결된 링크드 리스트의 맨 끝 노드에서 시작합니다.
      while (slow != null) {  // slow 포인터가 null이 아닐 때까지 반복합니다.
        if (fast.val != slow.val) {  // fast 포인터와 slow 포인터가 가리키는 노드의 값이 다르면 회문이 아니므로 false를 반환합니다.
          return false;
        }
        fast = fast.next;  // fast 포인터는 한 번에 한 노드씩 이동합니다.
        slow = slow.next;  // slow 포인터는 한 번에 한 노드씩 이동합니다.
      }
      return true;  // 모든 노드의 값이 같으면 회문이므로 true를 반환합니다.
    }
  }


  public static class PalindromeLinkedListSolutionV1 implements PalindromeLinkedListInterface {

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

  interface PalindromeLinkedListInterface {

    boolean isPalindrome(ListNode head);
  }
}


