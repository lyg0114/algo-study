package leetCode.topInterView.Array;

import static org.junit.Assert.assertEquals;

import leetCode.topInterView.Array.SearchRotatedSortedArray.SearchRotatedSortedArrayInterface;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Array
 * @since : 2023/05/30
 */
public class SearchRotatedSortedArrayTest {

  @Test
  public void test_search() {
    SearchRotatedSortedArrayInterface solution = SearchRotatedSortedArray.getSolution();
    int[] nums = {4, 5, 6, 7, 0, 1, 2};
    int actual = solution.search(nums, 0);
    assertEquals(4, actual);
  }
}