package leetCode.topInterView.DFS;

import static org.junit.Assert.assertEquals;

import leetCode.topInterView.DFS.UniquePaths.UniquePathsInterface;
import leetCode.topInterView.DFS.UniquePaths.UniquePathsSolutionV1;
import leetCode.topInterView.DFS.UniquePaths.UniquePathsSolutionV2;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.DFS
 * @since : 2023/06/13
 */
public class UniquePathsTest {

  @Test
  public void test_uniquePaths_1() {
    UniquePathsInterface solution = UniquePaths.getSolution();
    int actual = solution.uniquePaths(3, 2);
    assertEquals(3, actual);
  }

  @Test
  public void test_uniquePaths_2() {
    UniquePathsInterface solution = UniquePaths.getSolution();
    int actual = solution.uniquePaths(23, 12);
    assertEquals(193536720, actual);
  }

  @Test
  public void test_compare_v1_v2() {
    UniquePathsSolutionV1 v1 = new UniquePathsSolutionV1();
    UniquePathsSolutionV2 v2 = new UniquePathsSolutionV2();
    int actualV1 = v1.uniquePaths(23, 12);
    int actualV2 = v2.uniquePaths(23, 12);
    assertEquals(actualV1, actualV2);
  }
}