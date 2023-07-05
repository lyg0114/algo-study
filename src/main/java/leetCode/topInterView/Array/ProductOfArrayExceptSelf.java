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
      int n = nums.length;
      int[] answer = new int[n];
      answer[0] = 1;

      for (int i = 1; i < n; i++) {
        answer[i] = answer[i - 1] * nums[i - 1];
      }

      int rightProduct = 1;
      for (int i = n - 1; i >= 0; i--) {
        answer[i] *= rightProduct;
        rightProduct *= nums[i];
      }

      return answer;
    }
  }

  interface ProductOfArrayExceptSelfInterface {

    int[] productExceptSelf(int[] nums);
  }
}
