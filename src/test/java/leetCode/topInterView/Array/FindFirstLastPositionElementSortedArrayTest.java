package leetCode.topInterView.Array;

import static org.junit.Assert.*;

import leetCode.topInterView.Array.FindFirstLastPositionElementSortedArray.FindFirstLastPositionElementSortedArrayInterface;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Array
 * @since : 2023/06/01
 */
public class FindFirstLastPositionElementSortedArrayTest {

  @Test
  public void test_searchRange_1() {
    FindFirstLastPositionElementSortedArrayInterface solution = FindFirstLastPositionElementSortedArray
        .getSolution();

    int[] arr = {5, 7, 7, 8, 8, 10};
    int target = 8;
    int[] actuals = solution.searchRange(arr, target);
    int[] expects = {3,4};
    assertArrayEquals(expects, actuals);
  }

}