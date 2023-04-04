package leetCode.topInterView.linkedlist;

public class DeleteLinked {

  public static void main(String[] args) {
    DeleteLinkedSolution solution = new DeleteLinkedSolution();
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);

    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;

    solution.showNodes(node1);
    solution.deleteNode(node3);
    solution.showNodes(node1);
  }

}

class DeleteLinkedSolution {

  public void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
  }

  public void showNodes(ListNode head) {
    while (head != null) {
      System.out.print(head.val + " ");
      head = head.next;
    }
    System.out.println("");
  }
}
