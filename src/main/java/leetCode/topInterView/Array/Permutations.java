package leetCode.topInterView.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Array
 * @since : 2023/06/03
 */
public class Permutations {

  public static void main(String[] args) {
    PermutationsInterface solution = getSolution();
    int[] arr = {1, 2, 3};
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
      List<List<Integer>> res = new ArrayList<>();
      int n = nums.length;
      int r = 3;
      permuteRec(res, nums, n, r, 0);
      return res;
    }

    private void permuteRec(List<List<Integer>> res, int[] nums, int n, int r, int depth) {
      if (r == depth) {
        ArrayList<Integer> eles = new ArrayList<>();
        for (int i = 0; i < r; i++) {
          eles.add(nums[i]);
        }
        res.add(eles);
        return;
      }

      for (int i = depth; i < n; i++) {
        swap(nums, i, depth);
        permuteRec(res, nums, n, r, depth + 1);
        swap(nums, i, depth);
      }
    }

    private void swap(int[] nums, int i, int j) {
      int tmp;
      tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
    }
  }

  public interface PermutationsInterface {

    List<List<Integer>> permute(int[] nums);
  }
}
