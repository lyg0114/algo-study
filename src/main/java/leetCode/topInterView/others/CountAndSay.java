package leetCode.topInterView.others;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.others
 * @url : https://leetcode.com/problems/count-and-say/
 * @since : 2023/06/02
 */
public class CountAndSay {

  public static void main(String[] args) {
    CountAndSayInterface solution = getSolution();
    String s = solution.countAndSay(30);
    System.out.println("s = " + s);
  }

  public static CountAndSayInterface getSolution() {
    return new CountAndSaySolutionV1();
  }

  public static class CountAndSaySolutionV2 implements CountAndSayInterface {

    @Override
    public String countAndSay(int n) {
      if (n == 1) {
        return "1";
      }
      String s = countAndSay(n - 1);
      StringBuilder sb = new StringBuilder();
      int count = 1;
      int i = 0;
      while (i < s.length()) {
        char ch = s.charAt(i);
        i++;
        while (i < s.length() && s.charAt(i) == ch) {
          count++;
          i++;
        }
        sb.append(count).append(ch);
        count = 1;

      }
      return sb.toString();

    }
  }

  public static class CountAndSaySolutionV1 implements CountAndSayInterface {

    @Override
    public String countAndSay(int n) {
      return countAndSayRecursive(1, "1", n);
    }

    public String countAndSayRecursive(int cur, String res, int fin) {
      if (cur == fin) {
        return res;
      }

      StringBuffer sb = new StringBuffer();
      int target = Integer.parseInt(String.valueOf(res.charAt(0)));
      int l = 0;
      int r = 0;
      while (r < res.length() - 1) {
        if (r < res.length() - 1 && target != Integer.parseInt(String.valueOf(res.charAt(r + 1)))) {
          int tmp = target;
          target = Integer.parseInt(String.valueOf(res.charAt(r + 1)));
          sb.append(r - l + 1);
          sb.append(tmp);
          l = r + 1;
        }
        r++;
      }
      sb.append(r - l + 1);
      sb.append(target);
      res = sb.toString();
      return countAndSayRecursive(++cur, res, fin);
    }
  }

  public interface CountAndSayInterface {

    String countAndSay(int n);
  }
}
