package leetCode.topInterView.Array;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RemoveDuplicatesFromSortedArrayTest {

  @Test
  public void TESTremoveDuplicates() {
    int[] nums = {1, 1, 2};
    RemoveDuplicatesFromSortedArray rdfs = new RemoveDuplicatesFromSortedArray();
    int result = rdfs.removeDuplicates(nums);
    assertEquals(2, result);
  }

  @Test
  public void TESTdistinctArray() {
  }
}