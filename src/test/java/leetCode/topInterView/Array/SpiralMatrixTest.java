package leetCode.topInterView.Array;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import leetCode.topInterView.Array.SpiralMatrix.SpiralMatrixInterface;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Array
 * @since : 2023/06/15
 */
public class SpiralMatrixTest {

  @Test
  public void test_spiralOrder() {
    SpiralMatrixInterface solution = SpiralMatrix.getSolution();
    int[][] mtx = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    List<Integer> actual = solution.spiralOrder(mtx);
    List<Integer> expect = Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5);
    for (int i = 0; i < actual.size(); i++) {
      assertEquals(expect.get(i), actual.get(i));
    }
  }
}