package leetCode.topInterView.Array.moveZero;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Array.moveZero
 * @since : 2023/03/03
 */
class MoveZeroesMoveZeroesSolution implements MoveZeroesSolutionInterface {

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
