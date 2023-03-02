package leetCode.topInterView.easy.Array;
import java.util.HashSet;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.easy.Array
 * @since : 2023/03/02 https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/578/
 */
public class ContainsDuplicate {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums = {1, 2, 3, 1};
    System.out.println(solution.containsDuplicate(nums));
  }
}

class Solution {
  public boolean containsDuplicate(int[] nums) {
    HashSet<Integer> set = new HashSet<Integer>();
    for (int i = 0; i < nums.length; i++) {
      if(set.contains(nums[i])){
        return true;
      }
      set.add(nums[i]);
    }
    return false;
  }
}
