package leetCode.topInterView.others;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.others
 * @since : 2023/06/03
 */
public class Subsets {

  public static void main(String[] args) {
    SubsetsInterface solution = getSolution();
    int[] nums = {1, 2, 3, 4};
    List<List<Integer>> subsets = solution.subsets(nums);
    for (List<Integer> subset : subsets) {
      System.out.println("subset = " + subset);
    }
  }

  public static SubsetsInterface getSolution() {
    return new SubsetsSolutionV1();
  }

  public static class SubsetsSolutionV1 implements SubsetsInterface {

    private List<List<Integer>> res = new ArrayList<>();

    @Override
    public List<List<Integer>> subsets(int[] nums) {
      Stack<Integer> b = new Stack();
      for (int i = 0; i <= nums.length; i++) {
        combi(-1, nums.length, i, b, nums);
      }
      return res;
    }

    public void combi(int start, int n, int k, Stack<Integer> b, int[] nums) {
      if (b.size() == k) {
        ArrayList<Integer> lis = new ArrayList<>();
        for (Integer ele : b) {
          lis.add(nums[ele]);
        }
        res.add(lis);
        return;
      }
      for (int i = start + 1; i < n; i++) {
        b.push(i);
        combi(i, n, k, b, nums);
        b.pop();
      }
    }
  }

  public interface SubsetsInterface {

    List<List<Integer>> subsets(int[] nums);
  }
}
