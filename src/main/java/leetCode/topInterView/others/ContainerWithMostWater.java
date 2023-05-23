package leetCode.topInterView.others;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.others
 * @since : 2023/05/23
 */
public class ContainerWithMostWater {

  public static void main(String[] args) {
    ContainerWithMostWaterInterface solution = getSolution();
    int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    int result = solution.maxArea(height);
    System.out.println("result = " + result);
  }

  public static ContainerWithMostWaterInterface getSolution() {
    return new ContainerWithMostWaterSolution();
  }

  public static class ContainerWithMostWaterSolution implements ContainerWithMostWaterInterface {

    @Override
    public int maxArea(int[] height) {
      return 0;
    }
  }

  interface ContainerWithMostWaterInterface {

    int maxArea(int[] height);
  }
}
