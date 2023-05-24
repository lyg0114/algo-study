package leetCode.topInterView.others;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.others
 * @url : https://leetcode.com/problems/container-with-most-water/
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
    return new ContainerWithMostWaterSolutionV2();
  }

  public static class ContainerWithMostWaterSolutionV2 implements ContainerWithMostWaterInterface {

    @Override
    public int maxArea(int[] height) {
      int maxArea = 0;
      int left = 0;
      int right = height.length - 1;

      while (left < right) {
        int currentArea = Math.min(height[left], height[right]) * (right - left);
        maxArea = Math.max(maxArea, currentArea);

        if (height[left] < height[right]) {
          left++;
        } else {
          right--;
        }
      }

      return maxArea;
    }
  }

  public static class ContainerWithMostWaterSolutionV1 implements ContainerWithMostWaterInterface {

    @Override
    public int maxArea(int[] height) {
      if (height.length < 2) {
        return 0;
      }

      int maxStore = 0;
      for (int i = 1; i <= height.length - 1; i++) {
        int start = 0;
        int end = i;
        while (end < height.length) {
          int w = i;
          int h = Math.min(height[end], height[start]);
          int tmpStore = w * h;
          maxStore = Math.max(tmpStore, maxStore);
          start++;
          end++;
        }
      }
      return maxStore;
    }
  }

  interface ContainerWithMostWaterInterface {

    int maxArea(int[] height);
  }
}
