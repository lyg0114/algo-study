package baekjoon.greedy;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.greedy
 * @since : 16.11.23
 */
public class ChilMuHae14729 {

  public static void main(String[] args) {
    SolutionINterface solution = getSolution();
    solution.solution();
  }

  private static SolutionINterface getSolution() {
    return new SolutionV1();
  }

  static class SolutionV1 implements SolutionINterface {

    @Override
    public void solution() {

    }
  }

  interface SolutionINterface {

    void solution();
  }
}
