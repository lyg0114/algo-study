package leetCode.topInterView.others;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.others
 * @since : 2023/06/08
 */
public class HappyNumber {

  public static void main(String[] args) {
    HappyNumberInterface solution = getSolution();
  }

  public static HappyNumberInterface getSolution() {
    return new HappyNumberSolutionV1();
  }

  public static class HappyNumberSolutionV1 implements HappyNumberInterface {

    @Override
    public boolean isHappy(int n) {
      if (!(Integer.MIN_VALUE < n && n < Integer.MAX_VALUE)) {
        return false;
      }

      String s = String.valueOf(n);
      char[] nums = s.toCharArray();
      int res = 0;
      List<String> valid = new ArrayList<String>();
      while (res != 1) {
        res = 0;
        for (char num : nums) {
          int cur = Integer.parseInt(String.valueOf(num));
          res += cur * cur;
        }
        s = String.valueOf(res);
        if (valid.contains(s)) {
          return false;
        }
        valid.add(s);
        nums = s.toCharArray();
      }
      return true;
    }
  }


  public interface HappyNumberInterface {

    boolean isHappy(int n);
  }

}
