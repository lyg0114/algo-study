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
    System.out.println(solution.hammingDistance(1,4));
  }

  private static HammingDistanceInterfae getSolution() {
    return new HammingDistanceSolution();
  }

  public static class HammingDistanceSolution implements HammingDistanceInterfae {

    @Override
    public int hammingDistance(int x, int y) {
      String xStr = changeBinary(x);
      String yStr = changeBinary(y);

      String maxStr = null;
      String minStr = null;
      if (xStr.length() > yStr.length()) {
        maxStr = xStr;
        minStr = yStr;
      } else {
        maxStr = yStr;
        minStr = xStr;
      }

      int maxLength = Math.max(xStr.length(), yStr.length()) - 1;
      int minLength = Math.min(xStr.length(), yStr.length()) - 1;
      int result = 0;

      while (maxLength > 0) {
        if (maxLength > 0 && minLength > 0) {
          result += maxStr.charAt(maxLength) == minStr.charAt(minLength) ? 1 : 0;
          maxLength--;
          minLength--;
        } else {
          result += maxStr.charAt(maxLength) == '0' ? 1 : 0;
          maxLength--;
        }
      }
      return result;
    }

    private String changeBinary(int target) {
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
      return sb.toString();
    }
  }


  interface HammingDistanceInterfae {

    int hammingDistance(int x, int y);
  }
}
