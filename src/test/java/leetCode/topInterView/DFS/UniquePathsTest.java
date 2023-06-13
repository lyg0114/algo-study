package leetCode.topInterView.DFS;

import leetCode.topInterView.DFS.UniquePaths.UniquePathsInterface;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.DFS
 * @since : 2023/06/13
 */
public class UniquePathsTest {

  @Test
  public void test_uniquePaths() {
    UniquePathsInterface solution = UniquePaths.getSolution();
    int i = solution.uniquePaths(23, 12);
    System.out.println("i = " + i);
  }
}