package leetcode.topinterview.array;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Array
 * @since : 2023/03/02 https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/567/
 */
public class MoveZeroes {

  public static void main(String[] args) {
    int[] nums = {0, 1, 0, 3, 12};
    MoveZeroesSolutionInterface solution = getSolution();

    for (int i = 0; i < nums.length; i++) {
      System.out.print(nums[i] + ",");
    }
    solution.moveZeroes(nums);
    System.out.println("");
    for (int i = 0; i < nums.length; i++) {
      System.out.print(nums[i] + ",");
    }
  }

  public static MoveZeroesMoveZeroesSolutionV1 getSolution() {
    return new MoveZeroesMoveZeroesSolutionV1();
  }

  public static class MoveZeroesMoveZeroesSolutionV2 implements MoveZeroesSolutionInterface {

    public void moveZeroes(int[] nums) {
      int n = nums.length;
      if (n < 2) {
        return;
      }
      int L = 0, R = 1;
      while (R < n) {
        if (nums[L] != 0) {
          L++;
          R++;
        } else if (nums[R] == 0) {
          R++;
        } else {
          int temp = nums[R];
          nums[R] = nums[L];
          nums[L] = temp;
        }
      }
    }
  }

  public static class MoveZeroesMoveZeroesSolutionV1 implements MoveZeroesSolutionInterface {

    public void moveZeroes(int[] nums) {
      moveZero(nums);
      moveZero(nums);
      moveZero(nums);
    }

    private void moveZero(int[] nums) {
      for (int i = 0; i < nums.length; i++) {
        change(nums, i);
      }
    }

    public void change(int[] nums, int index) {
      if (index == nums.length - 1) {
        return;
      }

      if (nums[index] == 0) {
        int tmp = nums[index + 1];
        nums[index + 1] = nums[index];
        nums[index] = tmp;
        change(nums, ++index);
      }
    }
  }

  public interface MoveZeroesSolutionInterface {

    void moveZeroes(int[] nums);
  }
}



















