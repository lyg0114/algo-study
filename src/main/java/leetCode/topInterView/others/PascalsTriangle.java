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
    solution.generate(3);
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

      List<List<Integer>> arrayLists = new ArrayList<>();
      if (numRows == 1) {
        arrayLists.add(Arrays.asList(1));
        return arrayLists;
      }
      if (numRows == 2) {
        arrayLists.add(Arrays.asList(1,2));
        return arrayLists;
      }

      for (int i = 2; i < numRows; i++) {

      }

      return null;
    }
  }


  interface PascalsTriangleInterface {

    List<List<Integer>> generate(int numRows);
  }
}

