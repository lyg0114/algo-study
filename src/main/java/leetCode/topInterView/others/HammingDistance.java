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
    System.out.println(solution.hammingDistance(2147483647, 0));
  }

  private static HammingDistanceInterfae getSolution() {
    return new HammingDistanceSolution();
  }

  public static class HammingDistanceSolution2 implements HammingDistanceInterfae {

    @Override
    public int hammingDistance(int x, int y) {
      int xor = x ^ y;
      int distance = 0;

      while (xor != 0) {
        distance += xor & 1;
        xor >>= 1;
      }

      return distance;
    }
  }

  public static class HammingDistanceSolution implements HammingDistanceInterfae {

    @Override
    public int hammingDistance(int x, int y) {
      if (!(validation(x) && validation(x))) {
        return 0;
      }

      String xStr = changeBinary(x);
      String yStr = changeBinary(y);
      String maxStr, minStr = null;
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

      while (maxLength > -1) {
        if (maxLength > -1 && minLength > -1) {
          result += maxStr.charAt(maxLength) != minStr.charAt(minLength) ? 1 : 0;
          maxLength--;
          minLength--;
        } else {
          result += maxStr.charAt(maxLength) == '1' ? 1 : 0;
          maxLength--;
        }
      }

      return result;
    }

    public String changeBinary(int target) {
      if (target == 0) {
        return "0";
      }

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

    private boolean validation(int target) {
      if (Integer.MIN_VALUE <= target && Integer.MAX_VALUE >= target) {
        return true;
      } else {
        return false;
      }
    }

  }


  interface HammingDistanceInterfae {

    int hammingDistance(int x, int y);
  }
}
