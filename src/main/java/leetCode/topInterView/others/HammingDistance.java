package leetCode.topInterView.others;

import java.util.Stack;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.others
 * @since : 2023/05/15
 */
public class HammingDistance {

  public static void main(String[] args) {
    HammingDistanceInterfae solution = getSolution();
//    System.out.println(solution.hammingDistance(1, 4));
    System.out.println(solution.hammingDistance(3, 4));
  }

  private static HammingDistanceInterfae getSolution() {
    return new HammingDistanceSolution();
  }

  public static class HammingDistanceSolution implements HammingDistanceInterfae {

    @Override
    public int hammingDistance(int x, int y) {
      changeBinary(x);

      return 0;
    }

    private void changeBinary(int target) {
      Stack<String> stack = new Stack<>();
      while (target != 1) {
        stack.push(String.valueOf(target % 2));
        target = target / 2;
      }
      stack.push("1");

      StringBuffer sb = new StringBuffer();
      while (!stack.isEmpty()) {
        sb.append(stack.pop());
      }
    }
  }


  interface HammingDistanceInterfae {

    int hammingDistance(int x, int y);
  }
}
