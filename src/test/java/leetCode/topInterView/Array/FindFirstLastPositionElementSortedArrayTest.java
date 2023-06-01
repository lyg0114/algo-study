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
    int[] expects = {3, 4};
    assertArrayEquals(expects, actuals);
  }

  @Test
  public void test_searchRange_2() {
    FindFirstLastPositionElementSortedArrayInterface solution = FindFirstLastPositionElementSortedArray
        .getSolution();

    int[] arr = {5, 7, 7, 8, 8, 10};
    int target = 7;
    int[] actuals = solution.searchRange(arr, target);
    int[] expects = {1, 2};
    assertArrayEquals(expects, actuals);
  }

  @Test
  public void test_searchRange_3() {
    FindFirstLastPositionElementSortedArrayInterface solution = FindFirstLastPositionElementSortedArray
        .getSolution();

    int[] arr = {5, 7, 7, 8, 8, 10};
    int target = 6;
    int[] actuals = solution.searchRange(arr, target);
    int[] expects = {-1, -1};
    assertArrayEquals(expects, actuals);
  }

  @Test
  public void test_searchRange_4() {
    FindFirstLastPositionElementSortedArrayInterface solution = FindFirstLastPositionElementSortedArray
        .getSolution();

    int[] arr = {};
    int target = 0;
    int[] actuals = solution.searchRange(arr, target);
    int[] expects = {-1, -1};
    assertArrayEquals(expects, actuals);
  }

  @Test
  public void test_searchRange_5() {
    FindFirstLastPositionElementSortedArrayInterface solution = FindFirstLastPositionElementSortedArray
        .getSolution();

    int[] arr = {1};
    int target = 1;
    int[] actuals = solution.searchRange(arr, target);
    int[] expects = {0, 0};
    assertArrayEquals(expects, actuals);
  }

  @Test
  public void test_searchRange_6() {
    FindFirstLastPositionElementSortedArrayInterface solution = FindFirstLastPositionElementSortedArray
        .getSolution();

    int[] arr = {2, 2};
    int target = 2;
    int[] actuals = solution.searchRange(arr, target);
    int[] expects = {0, 1};
    assertArrayEquals(expects, actuals);
  }

  @Test
  public void test_searchRange_7() {
    FindFirstLastPositionElementSortedArrayInterface solution = FindFirstLastPositionElementSortedArray
        .getSolution();

    int[] arr = {0, 2, 2};
    int target = 2;
    int[] actuals = solution.searchRange(arr, target);
    int[] expects = {1, 2};
    assertArrayEquals(expects, actuals);
  }

  @Test
  public void test_searchRange_8() {
    FindFirstLastPositionElementSortedArrayInterface solution = FindFirstLastPositionElementSortedArray
        .getSolution();

    int[] arr = {1, 4};
    int target = 4;
    int[] actuals = solution.searchRange(arr, target);
    int[] expects = {1, 1};
    assertArrayEquals(expects, actuals);
  }

  @Test
  public void test_searchRange_9() {
    FindFirstLastPositionElementSortedArrayInterface solution = FindFirstLastPositionElementSortedArray
        .getSolution();

    int[] arr = {1, 2, 3, 3, 3, 4, 5, 6};
    int target = 3;
    int[] actuals = solution.searchRange(arr, target);
    int[] expects = {2, 4};
    assertArrayEquals(expects, actuals);
  }

  @Test
  public void test_searchRange_10() {
    FindFirstLastPositionElementSortedArrayInterface solution = FindFirstLastPositionElementSortedArray
        .getSolution();

    int[] arr = {1, 1, 2};
    int target = 1;
    int[] actuals = solution.searchRange(arr, target);
    int[] expects = {0, 1};
    assertArrayEquals(expects, actuals);
  }

}