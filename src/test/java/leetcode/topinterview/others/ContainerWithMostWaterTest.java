package leetcode.topinterview.others;

import static org.junit.Assert.*;

import leetcode.topinterview.others.ContainerWithMostWater.ContainerWithMostWaterInterface;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.others
 * @since : 2023/05/23
 */
public class ContainerWithMostWaterTest {

  @Test
  public void tets_ContainerWithMostWater_1() {
    ContainerWithMostWaterInterface solution = ContainerWithMostWater.getSolution();
    int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    int result = solution.maxArea(height);
    assertEquals(49, result);
  }

  @Test
  public void tets_ContainerWithMostWater_2() {
    ContainerWithMostWaterInterface solution = ContainerWithMostWater.getSolution();
    int[] height = {1, 1};
    int result = solution.maxArea(height);
    assertEquals(1, result);
  }

}
