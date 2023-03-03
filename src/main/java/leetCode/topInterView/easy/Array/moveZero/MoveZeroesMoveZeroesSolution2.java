package leetCode.topInterView.easy.Array.moveZero;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.easy.Array.moveZero
 * @since : 2023/03/03
 */
class MoveZeroesMoveZeroesSolution2 implements MoveZeroesSolutionInterface {

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
