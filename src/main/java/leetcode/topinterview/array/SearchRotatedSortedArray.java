package leetcode.topinterview.array;

import java.util.ArrayList;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Array
 * @since : 2023/05/30
 */
public class SearchRotatedSortedArray {

  public static void main(String[] args) {
    int[] nums = {4, 5, 6, 7, 8, 9, 0, 1, 2};
    SearchRotatedSortedArrayInterface solution = getSolution();
    int actual = solution.search(nums, 0);
    System.out.println("actual = " + actual);
  }

  public static SearchRotatedSortedArrayInterface getSolution() {
    return new SearchRotatedSortedArraySolutionV2();
  }

  public static class SearchRotatedSortedArraySolutionV2 implements
      SearchRotatedSortedArrayInterface {

    @Override
    public int search(int[] nums, int target) {
      int left = 0;
      int right = nums.length - 1;

      while (left <= right) {
        int mid = (left + right) / 2;

        if (nums[mid] == target) {
          return mid;
        }

        if (nums[left] <= nums[mid]) {
          if (nums[left] <= target && target < nums[mid]) {
            right = mid - 1;
          } else {
            left = mid + 1;
          }
        } else { // nums[left] > nums[mid]
          if (nums[mid] < target && target <= nums[right]) {
            left = mid + 1;
          } else {
            right = mid - 1;
          }
        }
      }

      return -1;
    }
  }

  public static class SearchRotatedSortedArraySolutionV1 implements
      SearchRotatedSortedArrayInterface {

    @Override
    public int search(int[] nums, int target) {
      if (nums.length == 1) {
        if (nums[0] == target) {
          return 0;
        } else {
          return -1;
        }
      }

      if (nums.length == 2) {
        for (int i = 0; i < nums.length; i++) {
          if (nums[i] == target) {
            return i;
          }
        }
        return -1;
      }

      ArrayList<Integer> firsts = new ArrayList<>();
      ArrayList<Integer> seconds = new ArrayList<>();
      int i = 0;
      while (true) {
        firsts.add(nums[i]);
        if (nums[i] > nums[i + 1]) {
          break;
        }
        i++;
      }

      int j = i + 1;
      while (j < nums.length) {
        seconds.add(nums[j]);
        j++;
      }

      int f1 = binarySearch(firsts, target);
      int s1 = binarySearch(seconds, target);

      if (f1 != -1) {
        return f1;
      } else {
        if (s1 != -1) {
          return firsts.size() + s1;
        } else {
          return -1;
        }
      }
    }

    public int binarySearch(ArrayList<Integer> arrayList, int target) {
      int left = 0;
      int right = arrayList.size() - 1;

      while (left <= right) {
        int mid = left + (right - left) / 2;
        int midValue = arrayList.get(mid);

        if (midValue == target) {
          return mid;
        } else if (midValue < target) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }

      return -1;
    }
  }

  public interface SearchRotatedSortedArrayInterface {

    int search(int[] nums, int target);
  }
}
