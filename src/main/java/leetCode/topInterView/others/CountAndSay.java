package leetCode.topInterView.others;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.others
 * @url : https://leetcode.com/problems/count-and-say/
 * @since : 2023/06/02
 */
public class CountAndSay {

  /*
    countAndSay(1) = "1"
    countAndSay(2) = say "1" = one 1 = "11"
    countAndSay(3) = say "11" = two 1's = "21"
    countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
    countAndSay(5) = say "1211" = one 1 + two 2 + one 1 + one 1 = "11221111"
*/
  public static void main(String[] args) {
    CountAndSayInterface solution = getSolution();

  }

  public static CountAndSayInterface getSolution() {
    return new CountAndSaySolutionV1();
  }

  public static class CountAndSaySolutionV1 implements CountAndSayInterface {

    @Override
    public String countAndSay(int n) {
      String res = "1";
      countAndSayRecursive(1, res, n);

      return null;
    }

    public void countAndSayRecursive(int cur, String res, int fin) {
      if (cur == fin) {
        return;
      }


    }
  }

  public interface CountAndSayInterface {

    String countAndSay(int n);
  }
}
