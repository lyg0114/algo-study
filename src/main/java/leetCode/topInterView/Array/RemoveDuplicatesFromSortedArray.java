package leetCode.topInterView.Array;

public class RemoveDuplicatesFromSortedArray {

  public static void main(String[] args) {
    RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
//    int[] inputNums = {1, 1, 2};
    int[] inputNums = {0,0,1,1,1,2,2,3,3,4};
    int result = removeDuplicatesFromSortedArray.removeDuplicates(inputNums);
    System.out.println("result = " + result);
    for (int inputNum : inputNums) {
      System.out.print(inputNum + ", ");
    }
  }

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

