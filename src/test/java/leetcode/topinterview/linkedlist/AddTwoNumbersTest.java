package leetcode.topinterview.linkedlist;

import leetcode.topinterview.linkedlist.AddTwoNumbers.AddTwoNumbersInterface;
import leetcode.topinterview.linkedlist.AddTwoNumbers.AddTwoNumbersSolution;
import org.junit.Test;


/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.linkedlist
 * @since : 2023/05/17
 */
public class AddTwoNumbersTest {

  private static AddTwoNumbersInterface getSolution() {
    return new AddTwoNumbersSolution();
  }

  private void printNode(ListNode listNode) {
    while (listNode != null) {
      System.out.println("listNode.val = " + listNode.val);
      listNode = listNode.next;
    }
  }

  @Test
  public void both_null(){
    AddTwoNumbersInterface solution = getSolution();
    ListNode listNode = solution.addTwoNumbers(null, null);
    printNode(listNode);
  }

  @Test
  public void both_one_1(){
    AddTwoNumbersInterface solution = getSolution();
    ListNode listNodeA = new ListNode(2);
    ListNode listNodeX = new ListNode(5);
    ListNode listNode = solution.addTwoNumbers(listNodeA, listNodeX);
    printNode(listNode);
  }

  @Test
  public void both_one_2(){
    AddTwoNumbersInterface solution = getSolution();
    ListNode listNodeA = new ListNode(0);
    ListNode listNodeX = new ListNode(0);
    ListNode listNode = solution.addTwoNumbers(listNodeA, listNodeX);
    printNode(listNode);
  }

  @Test
  public void both_one_3(){
    AddTwoNumbersInterface solution = getSolution();
    ListNode listNodeA = new ListNode(5);
    ListNode listNodeX = new ListNode(5);
    ListNode listNode = solution.addTwoNumbers(listNodeA, listNodeX);
    printNode(listNode);
  }

  @Test
  public void one_null_1(){
    AddTwoNumbersInterface solution = getSolution();
    ListNode listNodeA = null;
    ListNode listNodeX = new ListNode(5);
    ListNode listNodeY = new ListNode(6);
    ListNode listNodeZ = new ListNode(4);
    ListNode listNodeZ1 = new ListNode(3);
    listNodeX.next = listNodeY;
    listNodeY.next = listNodeZ;
    listNodeZ.next = listNodeZ1;
    ListNode listNode = solution.addTwoNumbers(listNodeA, listNodeX);
    printNode(listNode);
  }

  @Test
  public void both_not_null_and_more_than_two_and_same_count_1(){
    AddTwoNumbersInterface solution = getSolution();
    ListNode listNodeA = new ListNode(2);
    ListNode listNodeB = new ListNode(4);
    ListNode listNodeC = new ListNode(3);
    listNodeA.next = listNodeB;
    listNodeB.next = listNodeC;
    ListNode listNodeX = new ListNode(5);
    ListNode listNodeY = new ListNode(6);
    ListNode listNodeZ = new ListNode(4);
    listNodeX.next = listNodeY;
    listNodeY.next = listNodeZ;
    ListNode listNode = solution.addTwoNumbers(listNodeA, listNodeX);
    printNode(listNode);
  }

  @Test
  public void both_not_null_and_more_than_two_and_same_count_2(){
    AddTwoNumbersInterface solution = getSolution();
    ListNode listNodeA = new ListNode(2);
    ListNode listNodeB = new ListNode(4);
    listNodeA.next = listNodeB;
    ListNode listNodeX = new ListNode(5);
    ListNode listNodeY = new ListNode(6);
    listNodeX.next = listNodeY;
    ListNode listNode = solution.addTwoNumbers(listNodeA, listNodeX);
    printNode(listNode);
  }

  @Test
  public void both_not_null_and_more_than_two_but_not_same_count_1(){
    AddTwoNumbersInterface solution = getSolution();
    ListNode listNodeA = new ListNode(2);
    ListNode listNodeB = new ListNode(4);
    ListNode listNodeC = new ListNode(3);
    ListNode listNodeD = new ListNode(0);
    listNodeA.next = listNodeB;
    listNodeB.next = listNodeC;
    listNodeC.next = listNodeD;
    ListNode listNodeX = new ListNode(5);
    ListNode listNodeY = new ListNode(6);
    ListNode listNodeZ = new ListNode(4);
    ListNode listNodeZ1 = new ListNode(3);
    listNodeX.next = listNodeY;
    listNodeY.next = listNodeZ;
    listNodeZ.next = listNodeZ1;

    ListNode listNode = solution.addTwoNumbers(listNodeA, listNodeX);
    printNode(listNode);
  }

  @Test
  public void both_not_null_and_more_than_two_but_not_same_count_2(){
    AddTwoNumbersInterface solution = getSolution();
    ListNode listNodeA = new ListNode(9);
    ListNode listNodeB = new ListNode(9);
    ListNode listNodeC = new ListNode(9);
    ListNode listNodeD = new ListNode(9);
    ListNode listNodeE = new ListNode(9);
    ListNode listNodeF = new ListNode(9);
    ListNode listNodeG = new ListNode(9);
    listNodeA.next = listNodeB;
    listNodeB.next = listNodeC;
    listNodeC.next = listNodeD;
    listNodeD.next = listNodeE;
    listNodeE.next = listNodeF;
    listNodeF.next = listNodeG;

    ListNode listNodeX = new ListNode(9);
    ListNode listNodeY = new ListNode(9);
    ListNode listNodeZ = new ListNode(9);
    ListNode listNodeZ1 = new ListNode(9);
    listNodeX.next = listNodeY;
    listNodeY.next = listNodeZ;
    listNodeZ.next = listNodeZ1;

    ListNode listNode = solution.addTwoNumbers(listNodeA, listNodeX);
    printNode(listNode);
  }

}