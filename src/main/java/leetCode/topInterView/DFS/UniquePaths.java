package leetCode.topInterView.DFS;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.DFS
 * @since : 2023/06/13
 */
public class UniquePaths {

  public static void main(String[] args) {
    UniquePathsInterface solution = getSolution();
    int res = solution.uniquePaths(3, 7);
    System.out.println("res = " + res);
  }

  public static UniquePathsInterface getSolution() {
    return new UniquePathsSolutionV1();
  }

  public static class UniquePathsSolutionV1 implements UniquePathsInterface {

    @Override
    public int uniquePaths(int m, int n) {
      return 0;
    }
  }


  public interface UniquePathsInterface {

    int uniquePaths(int m, int n);
  }
}
