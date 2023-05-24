package leetCode.topInterView.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.others
 * @since : 2023/05/24
 */
public class Sum3 {

  public static void main(String[] args) {
    int[] nums = {-1, 0, 1, 2, -1, -4};
    Sum3Interface solution = getSolution();
    List<List<Integer>> lists = solution.threeSum(nums);
    System.out.println("lists = " + lists);
  }

  private static Sum3Interface getSolution() {
    return new Sum3SolutionV2();
  }

  public static class Sum3SolutionV2 implements Sum3Interface {

    @Override
    public List<List<Integer>> threeSum(int[] nums) {
      int target = 0;
      Arrays.sort(nums);
      Set<List<Integer>> s = new HashSet<>();
      List<List<Integer>> output = new ArrayList<>();

      for (int i = 0; i < nums.length; i++) {
        int j = i + 1;
        int k = nums.length - 1;
        while (j < k) {
          int sum = nums[i] + nums[j] + nums[k];
          System.out.println(
              "i,j,k = " + i + "," + j + "," + k
                  + " || nums[i], nums[j], nums[k] = " + nums[i] + "," + nums[j] + "," + nums[k]
                  + " || sum = " + sum + " target = " + target);
          if (sum == target) {
            j++;
            k--;
          } else if (sum < target) {
            j++;
          } else {
            k--;
          }
        }
      }

      output.addAll(s);
      return output;
    }

  }

  public static class Sum3SolutionV1 implements Sum3Interface {

    @Override
    public List<List<Integer>> threeSum(int[] nums) {
      Arrays.sort(nums);
      List<List<Integer>> result = new ArrayList<>();

      for (int i = 0; i < nums.length - 2; i++) {
        if (i > 0 && nums[i] == nums[i - 1]) {
          continue;
        }

        int target = -nums[i];
        int left = i + 1;
        int right = nums.length - 1;

        while (left < right) {
          int sum = nums[left] + nums[right];
          if (sum == target) {
            result.add(Arrays.asList(nums[i], nums[left], nums[right]));
            while (left < right && nums[left] == nums[left + 1]) {
              left++;
            }
            while (left < right && nums[right] == nums[right - 1]) {
              right--;
            }

            left++;
            right--;
          } else if (sum < target) {
            left++;
          } else {
            right--;
          }
        }
      }

      return result;
    }

  }

  interface Sum3Interface {

    List<List<Integer>> threeSum(int[] nums);
  }

}
