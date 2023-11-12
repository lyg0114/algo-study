package algolesson;

import java.util.ArrayList;

public class StandardPermutation {

  public static void main(String[] args) {
    StandardPermutationRefV1 perV1 = new StandardPermutationRefV1();
    int[] nums = {1, 2, 3};
    perV1.permuteRec(0, 3, 2, nums);
  }

  public static class StandardPermutationRefV1 {

    public void permuteRec(int depth, int n, int r, int[] nums) {
      if (r == depth) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < r; i++) {
          res.add(nums[i]);
        }
        System.out.println("res = " + res);
      }

      for (int i = depth; i < n; i++) {
        swap(i, depth, nums);
        permuteRec(depth + 1, n, r, nums);
        swap(i, depth, nums);
      }
    }

    private void swap(int i, int j, int[] nums) {
      int tmp;
      tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
    }
  }
}
