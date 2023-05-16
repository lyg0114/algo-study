package leetCode.topInterView.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.others
 * @since : 2023/05/16
 */
public class PascalsTriangle {

  public static void main(String[] args) {
    PascalsTriangleInterface solution = getSolution();
    System.out.println(solution.generate(5));
  }

  private static PascalsTriangleInterface getSolution() {
    return new PascalsTriangleSolution();
  }

  public static class PascalsTriangleSolution implements PascalsTriangleInterface {

    @Override
    public List<List<Integer>> generate(int numRows) {
      if (numRows == 0) {
        return null;
      }

      List<List<Integer>> results = new ArrayList<>();
      if (numRows == 1) {
        results.add(Arrays.asList(1));
        return results;
      }
      if (numRows == 2) {
        results.add(Arrays.asList(1));
        results.add(Arrays.asList(1, 1));
        return results;
      }

      results.add(Arrays.asList(1));
      results.add(Arrays.asList(1, 1));
      for (int i = 2; i < numRows; i++) {
        ArrayList<Integer> currents = new ArrayList<>();
        int length = i + 1;
        for (int j = 0; j < length; j++) {
          if (j == 0 || j == length - 1) {
            currents.add(1);
          } else {
            int cur = i;
            cur--;
            List<Integer> integers1 = results.get(cur);
            int before = j;
            before--;
            int sum = integers1.get(before).intValue() + integers1.get(j).intValue();
            currents.add(sum);
          }
        }
        results.add(currents);
      }
      return results;
    }
  }


  interface PascalsTriangleInterface {

    List<List<Integer>> generate(int numRows);
  }
}

