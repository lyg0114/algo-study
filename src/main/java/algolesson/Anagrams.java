package algolesson;

import java.util.HashMap;

/**
 * @author : iyeong-gyo
 * @package : algoLesson
 * @since : 2022/10/26
 *
 *
 */
public class Anagrams {
  public static void main(String[] args) {
    Anagrams anagrams = new Anagrams();
    String arr1[] = {"r","a","t"};
    String arr2[] = {"c","a","r"};
    boolean result = anagrams.validAnagram(arr1, arr2);
    System.out.println(result);
  }

  public boolean validAnagram(String[] arr1, String[] arr2) {
    if(arr1.length != arr2.length)
      return false;
    HashMap<String, Integer> map1 = new HashMap<String, Integer>();
    HashMap<String, Integer> map2 = new HashMap<String, Integer>();
    convertArrayToMap(arr1, map1);
    convertArrayToMap(arr2, map2);

    for (String m1Val : map1.keySet()) {
      Integer integer = map1.get(m1Val);
      Integer integer2 = map2.get(m1Val);
      if(integer != integer2)
        return false;
    }
    return true;
  }

  private void convertArrayToMap(String[] arr, HashMap<String, Integer> map) {
    for (String i : arr) {
      if (map.get(i) == null) {
        map.put(i, 1);
      } else {
        map.replace(i, map.get(i) + 1);
      }
    }
  }
}
