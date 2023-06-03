package leetCode.topInterView.others;

import java.util.List;
import leetCode.topInterView.others.Subsets.SubsetsInterface;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.others
 * @since : 2023/06/03
 */
public class SubsetsTest {

  @Test
  public void test_subsets_1() {
    SubsetsInterface solution = Subsets.getSolution();
    int[] nums = {1, 2, 3};
    List<List<Integer>> subsets = solution.subsets(nums);
    for (List<Integer> subset : subsets) {
      System.out.println("subset = " + subset);
    }
  }

  @Test
  public void test_subsets_2() {
    SubsetsInterface solution = Subsets.getSolution();
    int[] nums = {1, 2, 3, 4};
    List<List<Integer>> subsets = solution.subsets(nums);
    for (List<Integer> subset : subsets) {
      System.out.println("subset = " + subset);
    }
  }
}