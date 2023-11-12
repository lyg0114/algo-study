package leetcode.topinterview.array;

import java.util.HashSet;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Array
 * @since : 2023/03/02 https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/578/
 */
public class ContainsDuplicate {

  public static void main(String[] args) {
    ContainsDuplicateInterface solution = getSolution();
    int[] nums = {1, 2, 3, 1};
    System.out.println(solution.containsDuplicate(nums));
  }

  private static ContainsDuplicateInterface getSolution() {
    return new ContainsDuplicateSolutionV1();
  }

  public static class ContainsDuplicateSolutionV1 implements ContainsDuplicateInterface {

    @Override
    public boolean containsDuplicate(int[] nums) {
      HashSet<Integer> set = new HashSet<Integer>();
      for (int i = 0; i < nums.length; i++) {
        if (set.contains(nums[i])) {
          return true;
        }
        set.add(nums[i]);
      }
      return false;
    }
  }

  public interface ContainsDuplicateInterface {

    boolean containsDuplicate(int[] nums);
  }
}

