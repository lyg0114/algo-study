package codility.v2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : iyeong-gyo
 * @package : codility.v2
 * @since : 13.11.23 support@codility.com
 */
public class CodilitySolution3 {

  public static void main(String[] args) {
    String[] E = {"039", "4", "14", "32", "", "34", "7"};
    Solution solution = new Solution();
    int solution1 = solution.solution(E);
    System.out.println("solution1 = " + solution1);
  }

  static class Solution {

    public int solution(String[] E) {
      int days = 10;
      int[][] solutions = new int[E.length][days];
      for (int i = 0; i < E.length; i++) {
        char[] charArray = E[i].toCharArray();
        for (int j = 0; j < charArray.length; j++) {
          solutions[i][charArray[j] - '0'] = 1;
        }
      }

      ArrayList<Integer> sums = new ArrayList<>();

      for (int i = 0; i < days; i++) {
        int sum = 0;
        for (int j = 0; j < solutions.length; j++) {
          sum += solutions[j][i];
        }
        sums.add(sum);
      }

      for (Integer integer : sums) {
        System.out.println("integer = " + integer);
      }

      sums.sort(Collections.reverseOrder());
      int firstMax = sums.get(0);
      int secondMax = sums.get(1);

      int result = 0;
      for (int i = 0; i < solutions.length; i++) {
        if (solutions[i][firstMax] > 0 || solutions[i][secondMax] > 0) {
          result++;
        }
      }

      return result;
    }
  }
}
