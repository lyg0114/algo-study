package algoLesson;

import java.util.ArrayList;
import java.util.Stack;

public class StandardCombination {

  public static class StandardCombinationRefV1 {

    private Stack<Integer> idxStack = new Stack<>();

    public void combi(int start, int n, int r, int[] nums) {
      if (idxStack.size() == r) {
        printCombi(idxStack, nums);
        return;
      }
      for (int i = start + 1; i < n; i++) {
        idxStack.push(i);
        combi(i, n, r, nums);
        idxStack.pop();
      }
    }

    private void printCombi(Stack<Integer> idxStack, int[] nums) {
      ArrayList<Integer> res = new ArrayList<>();
      for (Integer idx : idxStack) {
        res.add(nums[idx]);
      }
      System.out.println("res = " + res);
    }
  }
}
