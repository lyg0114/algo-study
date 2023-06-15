package leetCode.topInterView.Array;

import static org.junit.Assert.*;

import java.util.ArrayList;
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
  public void test_spiralOrder_1() {
    SpiralMatrixInterface solution = SpiralMatrix.getSolution();
    int[][] mtx = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    List<Integer> actual = solution.spiralOrder(mtx);
    List<Integer> expect = Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5);
    for (int i = 0; i < actual.size(); i++) {
      assertEquals(expect.get(i), actual.get(i));
    }
  }

  @Test
  public void test_spiralOrder_2() {
    SpiralMatrixInterface solution = SpiralMatrix.getSolution();
    int[][] mtx = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
    List<Integer> actual = solution.spiralOrder(mtx);
    List<Integer> expect = Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7);
    for (int i = 0; i < actual.size(); i++) {
      assertEquals(expect.get(i), actual.get(i));
    }
  }

  @Test
  public void test_spiralOrder_3() {
    SpiralMatrixInterface solution = SpiralMatrix.getSolution();
    int[][] mtx = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}};
    List<Integer> actual = solution.spiralOrder(mtx);
    List<Integer> expect = Arrays.asList(1, 2, 3, 4, 5, 10, 9, 8, 7, 6);
    for (int i = 0; i < actual.size(); i++) {
      assertEquals(expect.get(i), actual.get(i));
    }
  }

  @Test
  public void test_spiralOrder_4() {
    SpiralMatrixInterface solution = SpiralMatrix.getSolution();
    int[][] mtx = {{1, 2, 3, 4, 5}};
    List<Integer> actual = solution.spiralOrder(mtx);
    List<Integer> expect = Arrays.asList(1, 2, 3, 4, 5);
    for (int i = 0; i < actual.size(); i++) {
      assertEquals(expect.get(i), actual.get(i));
    }
  }

  @Test
  public void test_spiralOrder_5() {
    SpiralMatrixInterface solution = SpiralMatrix.getSolution();
    int[][] mtx = {};
    List<Integer> actual = solution.spiralOrder(mtx);
    List<Integer> expect = new ArrayList<>();
    for (int i = 0; i < actual.size(); i++) {
      assertEquals(expect.get(i), actual.get(i));
    }
  }

  @Test
  public void test_spiralOrder_6() {
    SpiralMatrixInterface solution = SpiralMatrix.getSolution();
    int[][] mtx = {{3}, {2}};
    List<Integer> actual = solution.spiralOrder(mtx);
    List<Integer> expect = Arrays.asList(3, 2);
    for (int i = 0; i < actual.size(); i++) {
      assertEquals(expect.get(i), actual.get(i));
    }
  }

  @Test
  public void test_spiralOrder_7() {
    SpiralMatrixInterface solution = SpiralMatrix.getSolution();
    int[][] mtx = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
    List<Integer> actual = solution.spiralOrder(mtx);
    List<Integer> expect = Arrays.asList(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10);
    for (int i = 0; i < actual.size(); i++) {
      assertEquals(expect.get(i), actual.get(i));
    }
  }
}