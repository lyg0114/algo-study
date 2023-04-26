package algoLesson;

import java.util.HashMap;

/**
 * Write a fucntion called same, which accepts two arrays. The function should return true if every
 * value in the array has ist's corresponding value squared in the second array. The frequency of
 * values must be the same
 * <p>
 * ex) - same([1,2,3], [4,1,9]) //  true - same([1,2,3], [1,9]) //  false - same([1,2,1], [4,4,1])
 * // false (must be same frequency)
 */
public class FrequencyCounter {

  public static void main(String[] args) {
    FrequencyCounter frequencyCounter = new FrequencyCounter();
    int arr1[] = {1, 2, 3, 2, 5};
    int arr2[] = {9, 1, 4, 4, 11};
    boolean same = frequencyCounter.same(arr1, arr2);
    System.out.println("result = " + same);
  }

  public boolean same(int arr1[], int arr2[]) {
    if (arr1.length != arr2.length) {
      return false;
    }

    HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
    HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
    convertArrayToMap(arr1, map1);
    convertArrayToMap(arr2, map2);

    for (Integer m1Val : map1.keySet()) {
      Integer squared = m1Val * m1Val;
      if (map2.get(squared) == null) {
        return false;
      }
      if (map2.get(squared) != map1.get(m1Val)) {
        return false;
      }
    }
    return true;
  }

  private void convertArrayToMap(int[] arr, HashMap<Integer, Integer> map) {
    for (int i : arr) {
      if (map.get(i) == null) {
        map.put(i, 1);
      } else {
        map.replace(i, map.get(i) + 1);
      }
    }
  }
}
