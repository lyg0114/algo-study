package leetcode.topinterview.others;

import java.util.Stack;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.others
 * @since : 2023/05/15
 */
public class ReverseBits {

  public static void main(String[] args) {
    ReverseBitsInterface solution = getSolution();
    solution.reverseBits(14968252);
  }

  private static ReverseBitsInterface getSolution() {
    return new ReverseBitsSolution3();
  }

  public static class ReverseBitsSolution2 implements ReverseBitsInterface {
    @Override
    public int reverseBits(int n) {
      int result = 0;
      for (int i = 0; i < 32; i++) {
        result = (result << 1) | (n & 1);
        n >>= 1;
      }
      return result;
    }
  }

  public static class ReverseBitsSolution3 implements ReverseBitsInterface {
    @Override
    public int reverseBits(int n) {
      char[] results = Integer.toBinaryString(n).toCharArray();
      int left = 0;
      int right = results.length - 1;
      char tmp;
      while (left < right) {
        tmp = results[right];
        results[right] = results[left];
        results[left] = tmp;
        left++;
        right--;
      }
      return Integer.parseInt(new String(results));
    }
  }

  public static class ReverseBitsSolution implements ReverseBitsInterface {
    @Override
    public int reverseBits(int n) {
      String s = Integer.toBinaryString(n);
      int length = s.length();
      Stack<Character> stack = new Stack<>();
      for (int i = 0; i < length; i++) {
        stack.push(s.charAt(i));
      }
      StringBuffer sb = new StringBuffer();
      while (!stack.isEmpty()) {
        sb.append(stack.pop());
      }
      String resultStr = sb.toString();
      return Integer.parseInt(resultStr, 2);
    }
  }

  interface ReverseBitsInterface {
    int reverseBits(int n);
  }
}

