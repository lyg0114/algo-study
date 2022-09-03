package leetCode.topInterView.easy.Array;


import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
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
    int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    RemoveDuplicatesFromSortedArray rdfs = new RemoveDuplicatesFromSortedArray();
    HashMap<Integer, Integer> resultsMap = rdfs.distinctArray(nums);
//    for (Integer integer : resultsMap.keySet()) {
//      System.out.println("integer = " + integer);
//      System.out.println("resultsMap.get(integer) = " + resultsMap.get(integer));
//    }
//    assertEquals(5, resultsMap.size());
  }
}