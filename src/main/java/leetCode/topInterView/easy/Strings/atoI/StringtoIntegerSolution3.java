package leetCode.topInterView.easy.Strings.atoI;

import java.util.ArrayList;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.easy.Strings.atoI
 * @since : 2023/03/13
 */
public class StringtoIntegerSolution3 implements StringtoIntegerSolution {

  // TC: O(n)
  // SC: O(1)
  public int myAtoi(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    int res = 0;
    int sign = 1;

    s = s.trim();
    int idx = 0;
    int len = s.length();

    if (idx < len && (s.charAt(idx) == '+' || s.charAt(idx) == '-')) {
      sign = s.charAt(idx) == '+' ? 1 : -1;
      idx++;
    }

    while (idx < len && Character.isDigit(s.charAt(idx))) {
      char ch = s.charAt(idx);
      if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10
          && ch - '0' > Integer.MAX_VALUE % 10)) {
        return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }

      res = res * 10 + ch - '0';
      idx++;
    }

    return sign * res;
  }
}
