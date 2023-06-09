package leetCode.topInterView.linkedlist;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.linkedlist
 * @since : 2023/06/09
 */
public class IntersectionTwoLinkedLists {

  public static void main(String[] args) {
    IntersectionTwoLinkedListsInterface solution = getSolution();
  }

  public static IntersectionTwoLinkedListsInterface getSolution() {
    return new IntersectionTwoLinkedListsSolutionV1();
  }

  public static class IntersectionTwoLinkedListsSolutionV1 implements
      IntersectionTwoLinkedListsInterface {

    @Override
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      if (headA == null || headB == null) {
        return new ListNode(0);
      }

      return null;
    }
  }

  public interface IntersectionTwoLinkedListsInterface {

    ListNode getIntersectionNode(ListNode headA, ListNode headB);
  }
}

