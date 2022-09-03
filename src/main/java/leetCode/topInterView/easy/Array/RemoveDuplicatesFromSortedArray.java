package leetCode.topInterView.easy.Array;
/*

Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
The relative order of the elements should be kept the same.
Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums.
More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result.
It does not matter what you leave beyond the first k elements.
Return k after placing the final result in the first k slots of nums.
Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

- Example
Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

- Example  2,3,2,2,1 // 1,2,1,1,0
Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RemoveDuplicatesFromSortedArray {

  public int removeDuplicates(int[] nums) {

    // 1. collection distinct value list
    // 2. sum set of Count which minus 1 each count of value is OutPut

    return 0;
  }

  public HashMap<Integer, Integer> distinctArray(int[] numbs) {
    int currentValue;
    int currentValueCount = 0;
    List<Integer> results = new ArrayList<Integer>();
//    List<HashMap<Integer, Integer>> resultMaps =
//        new ArrayList<HashMap<Integer, Integer>>();

    HashMap<Integer, Integer> resultMaps = new HashMap<Integer, Integer>();

    currentValue = numbs[0];
    results.add(currentValue);
    for (int i = 0; i < numbs.length; i++) {
      if (currentValue != numbs[i]) {

        currentValue = numbs[i];
        results.add(currentValue);
        currentValueCount = 1;

        if (i == (numbs.length - 1)) {
          addMapToList(currentValue, currentValueCount, resultMaps);
        }
      } else {
        currentValueCount++;
      }
    }

    int blankCount = 0;
    List<Integer> finalResults = new ArrayList<Integer>();
    for (Integer integer : resultMaps.keySet()) {
      blankCount += (resultMaps.get(integer) - 1);
      finalResults.add(integer);
    }
    for (int i = 0; i < blankCount ; i++) {
      finalResults.add(99);
    }


    return resultMaps;
  }

  private void addMapToList(int currentValue, int currentValueCount,
      HashMap<Integer, Integer> resultMaps) {
    resultMaps.put(currentValue, currentValueCount);
  }


}

