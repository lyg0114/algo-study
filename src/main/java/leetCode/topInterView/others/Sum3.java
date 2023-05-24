package leetCode.topInterView.others;

import java.util.List;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.others
 * @since : 2023/05/24
 */
public class Sum3 {

  public static void main(String[] args) {
    Sum3Interface solution = getSolution();
  }

  private static Sum3Interface getSolution() {
    return new Sum3Solution();
  }

  public static class Sum3Solution implements Sum3Interface {

    @Override
    public List<List<Integer>> threeSum(int[] nums) {
      return null;
    }
  }

  interface Sum3Interface {

    List<List<Integer>> threeSum(int[] nums);
  }

}
