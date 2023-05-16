package leetCode.topInterView.others;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.others
 * @since : 2023/05/16
 */
public class MissingNumber {

  public static void main(String[] args) {
    MissingNumberInterface solution = getSolution();
  }

  private static MissingNumberInterface getSolution() {
    return new MissingNumberSolution();
  }

  public static class MissingNumberSolution implements MissingNumberInterface {

    @Override
    public int missingNumber(int[] nums) {
      return 0;
    }
  }

  interface MissingNumberInterface {

    int missingNumber(int[] nums);
  }
}
