package leetCode.topInterView.Array;

import java.util.List;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Array
 * @since : 2023/06/03
 */
public class Permutations {

  public static void main(String[] args) {
    PermutationsInterface solution = getSolution();
    int [] arr = {1,2,3};
    List<List<Integer>> permute = solution.permute(arr);
    for (List<Integer> integers : permute) {
      System.out.println("integers = " + integers);
    }
  }

  public static PermutationsInterface getSolution() {
    return new PermutationsSolutionV1();
  }

  public static class PermutationsSolutionV1 implements PermutationsInterface {

    @Override
    public List<List<Integer>> permute(int[] nums) {
      return null;
    }
  }

  public interface PermutationsInterface {

    List<List<Integer>> permute(int[] nums);
  }
}
