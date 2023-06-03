package leetCode.topInterView.Array;

import java.util.List;
import leetCode.topInterView.Array.Permutations.PermutationsInterface;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Array
 * @since : 2023/06/03
 */
public class PermutationsTest {

  @Test
  public void test_permute_1() {
    PermutationsInterface solution = Permutations.getSolution();
    int[] arr = {1, 2, 3};
    List<List<Integer>> permute = solution.permute(arr);
    for (List<Integer> integers : permute) {
      System.out.println("integers = " + integers);
    }
  }
}