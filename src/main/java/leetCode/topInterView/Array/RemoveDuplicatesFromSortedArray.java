package leetCode.topInterView.Array;

public class RemoveDuplicatesFromSortedArray {

  public static void main(String[] args) {
    int[] inputNums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    RemoveDuplicatesFromSortedArrayInterface solution = getSolution();
    int result = solution.removeDuplicates(inputNums);
    System.out.println("result = " + result);
    for (int inputNum : inputNums) {
      System.out.print(inputNum + ", ");
    }
  }

  public static RemoveDuplicatesFromSortedArrayInterface getSolution() {
    return new RemoveDuplicatesFromSortedArraySolutionV2();
  }

  public static class RemoveDuplicatesFromSortedArraySolutionV2 implements
      RemoveDuplicatesFromSortedArrayInterface {

    @Override
    public int removeDuplicates(int[] nums) {
      if (nums == null || nums.length == 0) {
        return 0;
      }

      if (nums.length == 1) {
        return 1;
      }

      int[] tmp = new int[nums.length];
      tmp[0] = nums[0];
      int tmpCur = 1;
      int before;

      for (int i = 0; i < nums.length; i++) {
        if (i > 0) {
          before = i;
          before--;
          if (nums[before] != nums[i]) {
            tmp[tmpCur++] = nums[i];
          }
        }
      }

      for (int i = 0; i < nums.length; i++) {
        if (i < tmpCur) {
          nums[i] = tmp[i];
        } else {
          nums[i] = 0;
        }
      }

      return tmpCur;
    }
  }


  public static class RemoveDuplicatesFromSortedArraySolution implements
      RemoveDuplicatesFromSortedArrayInterface {

    @Override
    public int removeDuplicates(int[] nums) {
      int insertIndex = 1;
      for (int i = 1; i < nums.length; i++) {
        if (nums[i - 1] != nums[i]) {
          nums[insertIndex] = nums[i];
          insertIndex++;
        }
      }
      return insertIndex;
    }
  }

  interface RemoveDuplicatesFromSortedArrayInterface {

    int removeDuplicates(int[] nums);
  }
}

