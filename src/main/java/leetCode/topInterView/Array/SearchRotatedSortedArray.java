package leetCode.topInterView.Array;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Array
 * @since : 2023/05/30
 */
public class SearchRotatedSortedArray {

  public static void main(String[] args) {

    SearchRotatedSortedArrayInterface solution = getSolution();
  }

  public static SearchRotatedSortedArrayInterface getSolution() {
    return new SearchRotatedSortedArraySolutionV1();
  }

  public static class SearchRotatedSortedArraySolutionV1 implements
      SearchRotatedSortedArrayInterface {

    @Override
    public int search(int[] nums, int target) {
      return 0;
    }
  }

  public interface SearchRotatedSortedArrayInterface {

    int search(int[] nums, int target);
  }
}
