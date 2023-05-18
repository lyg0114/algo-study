package leetCode.topInterView.Array;


import static org.junit.Assert.assertEquals;

import leetCode.topInterView.Array.RemoveDuplicatesFromSortedArray.RemoveDuplicatesFromSortedArrayInterface;
import org.junit.Test;

public class RemoveDuplicatesFromSortedArrayTest {

  @Test
  public void TESTremoveDuplicates() {
    int[] nums = {1, 1, 2};
    RemoveDuplicatesFromSortedArrayInterface solution = RemoveDuplicatesFromSortedArray
        .getSolution();
    int result = solution.removeDuplicates(nums);
    assertEquals(2, result);
  }

  @Test
  public void test_operation() {
    int num = 3;
    System.out.println("num-- = " + --num);
    System.out.println("num = " + num);
  }
}