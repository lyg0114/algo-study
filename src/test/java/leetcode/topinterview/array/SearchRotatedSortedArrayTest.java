package leetcode.topinterview.array;

import static org.junit.Assert.assertEquals;

import leetcode.topinterview.array.SearchRotatedSortedArray.SearchRotatedSortedArrayInterface;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Array
 * @since : 2023/05/30
 */
public class SearchRotatedSortedArrayTest {

  @Test
  public void test_search_1() {
    SearchRotatedSortedArrayInterface solution = SearchRotatedSortedArray.getSolution();
    int[] nums = {4, 5, 6, 7, 0, 1, 2};
    int actual = solution.search(nums, 0);
    assertEquals(4, actual);
  }

  @Test
  public void test_search_2() {
    SearchRotatedSortedArrayInterface solution = SearchRotatedSortedArray.getSolution();
    int[] nums = {4, 5, 6, 7, 0, 1, 2};
    int actual = solution.search(nums, 3);
    assertEquals(-1, actual);
  }

  @Test
  public void test_search_3() {
    SearchRotatedSortedArrayInterface solution = SearchRotatedSortedArray.getSolution();
    int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int actual = solution.search(nums, 2);
    assertEquals(1, actual);
  }

  @Test
  public void test_search_4() {
    SearchRotatedSortedArrayInterface solution = SearchRotatedSortedArray.getSolution();
    int[] nums = {1, 3};
    int actual = solution.search(nums, 0);
    assertEquals(-1, actual);
  }

  @Test
  public void test_search_5() {
    SearchRotatedSortedArrayInterface solution = SearchRotatedSortedArray.getSolution();
    int[] nums = {1, 3};
    int actual = solution.search(nums, 1);
    assertEquals(0, actual);
  }

  @Test
  public void test_search_6() {
    SearchRotatedSortedArrayInterface solution = SearchRotatedSortedArray.getSolution();
    int[] nums = {1, 3};
    int actual = solution.search(nums, 4);
    assertEquals(-1, actual);
  }

  @Test
  public void test_search_7() {
    SearchRotatedSortedArrayInterface solution = SearchRotatedSortedArray.getSolution();
    int[] nums = {10, 11, 14, 16, 1, 3, 5, 7, 9};
    int actual = solution.search(nums, 16);
    assertEquals(3, actual);
  }
}