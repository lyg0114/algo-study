package leetcode.topinterview;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView
 * @since : 12.11.23
 */
public class GasStation134 {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int gas[] = {1, 2, 3, 4, 5};
    int coast[] = {3, 4, 5, 1, 2};
    int result = solution.canCompleteCircuit(gas, coast);
    System.out.println("result = " + result);
  }

  static class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
      if (gas.length != cost.length) {
        return -1;
      }
      return 0;
    }
  }

}
