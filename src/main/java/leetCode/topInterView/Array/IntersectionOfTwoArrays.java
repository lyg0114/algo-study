package leetCode.topInterView.Array;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Array
 * @since : 2023/03/02 https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/674/
 */
public class IntersectionOfTwoArrays {
  public static void main(String[] args) {
    int[] nums1 = {1, 2, 2, 1};
    int[] nums2 = {2, 2};
    IntersectionOfTwoArraysSolutoin solutoin = new IntersectionOfTwoArraysSolutoin();
    int[] intersect = solutoin.intersect(nums1, nums2);
    for (int i = 0; i < intersect.length; i++) {
      System.out.println(intersect[i] + ", ");
    }
  }
}

class IntersectionOfTwoArraysSolutoin {
  public int[] intersect(int[] nums1, int[] nums2) {
    HashMap<Integer, Integer> map1 = converToHashMap(nums1);
    HashMap<Integer, Integer> map2 = converToHashMap(nums2);
    return intersectMap(map1, map2);
  }

  private int[] intersectMap(HashMap<Integer, Integer> map1,
      HashMap<Integer, Integer> map2) {
    ArrayList<Integer> results = new ArrayList<>();
    for (Integer key : map1.keySet()) {
      if (map1.containsKey(key) && map2.containsKey(key)) {
        if (map1.get(key) < map2.get(key)) {
          for (int i = 0; i < map1.get(key); i++) {
            results.add(key);
          }
        }
        if (map2.get(key) < map1.get(key)) {
          for (int i = 0; i < map2.get(key); i++) {
            results.add(key);
          }
        }
        if (map2.get(key) == map1.get(key)) {
          for (int i = 0; i < map2.get(key); i++) {
            results.add(key);
          }
        }
      }
    }
    return results.stream().mapToInt(i -> i).toArray();
  }

  public HashMap<Integer, Integer> converToHashMap(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        map.replace(nums[i], map.get(nums[i]) + 1);
      } else {
        map.put(nums[i], 1);
      }
    }
    return map;
  }
}
