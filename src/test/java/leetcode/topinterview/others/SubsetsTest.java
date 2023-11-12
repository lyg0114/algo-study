package leetcode.topinterview.others;

import java.util.List;
import java.util.Stack;
import leetcode.topinterview.others.Subsets.SubsetsInterface;
import leetcode.topinterview.others.Subsets.SubsetsSolutionV1;
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

  @Test
  public void test_combi_1() {
    SubsetsSolutionV1 solution = new SubsetsSolutionV1();
    int[] nums = {1, 2, 3};
    solution.combi(-1, 3, 2, new Stack<>(), nums);
  }
}