package leetCode.topInterView.Array;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Array
 * @since : 2023/07/05
 */
public class ProductOfArrayExceptSelf {

  public static void main(String[] args) {
    ProductOfArrayExceptSelfInterface solution = getSolution();
    int[] nums = {1, 2, 3, 4};
    int[] results = solution.productExceptSelf(nums);
    for (int res : results) {
      System.out.println(res);
    }
  }

  public static ProductOfArrayExceptSelfInterface getSolution() {
    return new ProductOfArrayExceptSelfSolutionV1();
  }

  public static class ProductOfArrayExceptSelfSolutionV1 implements
      ProductOfArrayExceptSelfInterface {

    @Override
    public int[] productExceptSelf(int[] nums) {
      return new int[0];
    }
  }

  interface ProductOfArrayExceptSelfInterface {

    int[] productExceptSelf(int[] nums);
  }
}
