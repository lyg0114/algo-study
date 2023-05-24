package leetCode.topInterView.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    return new Sum3Solution();
  }

  public static class Sum3Solution implements Sum3Interface {

    @Override
    public List<List<Integer>> threeSum(int[] nums) {
      Arrays.sort(nums); // 배열을 오름차순으로 정렬
      List<List<Integer>> result = new ArrayList<>();

      for (int i = 0; i < nums.length - 2; i++) {
        // 중복된 숫자는 건너뛰기
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

            // 중복된 숫자는 건너뛰기
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
