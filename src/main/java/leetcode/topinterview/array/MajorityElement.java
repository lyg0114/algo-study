package leetcode.topinterview.array;

import java.util.HashMap;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Array
 * @since : 2023/06/10
 */
public class MajorityElement {

  public static void main(String[] args) {
    MajorityElementInterface solution = getSolution();
  }

  public static MajorityElementInterface getSolution() {
    return new MajorityElementSolutionV1();
  }

  public static class MajorityElementSolutionV1 implements MajorityElementInterface {

    @Override
    public int majorityElement(int[] nums) {
      if (nums == null || nums.length == 0) {
        return 0;
      }

      int m = nums.length / 2;
      HashMap<Integer, Integer> map = new HashMap<>();
      for (int num : nums) {
        Integer val = map.getOrDefault(num, 0);
        map.put(num, ++val);
        if (val > m) {
          return num;
        }
      }
      return 0;
    }
  }

  public interface MajorityElementInterface {

    int majorityElement(int[] nums);
  }
}
