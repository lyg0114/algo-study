package repeat;

import leetcode.topinterview.others.ContainerWithMostWater.ContainerWithMostWaterInterface;

/**
 * @author : iyeong-gyo
 * @package : repeat
 * @since : 2023/05/28
 */
public class RepeatContainerWithMostWater implements ContainerWithMostWaterInterface {

  @Override
  public int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int maxArea = 0;
    int curArea = 0;

    while (left < right) {
      curArea = (right - left) * Math.min(height[left], height[right]);
      maxArea = Math.max(curArea,maxArea);
      if (height[left] < height[right]) {
        left++;
      } else if (height[left] > height[right]) {
        right--;
      } else {
        left++;
        right--;
      }
    }

    return maxArea;
  }
}
