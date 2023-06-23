package leetCode.topInterView.Array;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Array
 * @since : 2023/06/22
 */
public class KthLargestElementArray {

  public static void main(String[] args) {
    KthLargestElementArrayInterface solution = getSolution();
    int[] nums = {3, 2, 1, 5, 6, 4};
    solution.findKthLargest(nums, 2);
  }

  private static KthLargestElementArrayInterface getSolution() {
    return new KthLargestElementArraySolutionV1();
  }

  public static class KthLargestElementArraySolutionV1 implements KthLargestElementArrayInterface {

    @Override
    public int findKthLargest(int[] nums, int k) {
      return 0;
    }
  }

  public interface KthLargestElementArrayInterface {

    int findKthLargest(int[] nums, int k);
  }
}
