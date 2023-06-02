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

  public static class CountAndSaySolutionV1 implements CountAndSayInterface {

    @Override
    public String countAndSay(int n) {
      String res = "1";
      return countAndSayRecursive(1, res, n);
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
