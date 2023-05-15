package leetCode.topInterView.others;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.others
 * @since : 2023/05/15
 */
public class HammingDistance {

  public static void main(String[] args) {
    HammingDistanceInterfae solution = getSolution();
    System.out.println(solution.hammingDistance(1, 4));
  }

  private static HammingDistanceInterfae getSolution() {
    return new HammingDistanceSolution();
  }

  public static class HammingDistanceSolution implements HammingDistanceInterfae {

    @Override
    public int hammingDistance(int x, int y) {
      return 0;
    }
  }


  interface HammingDistanceInterfae {

    int hammingDistance(int x, int y);
  }
}
