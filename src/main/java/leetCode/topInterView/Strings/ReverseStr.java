package leetCode.topInterView.Strings;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Strings
 * @since : 2023/06/02
 */
public class ReverseStr {

  public static void main(String[] args) {
    String str = "Hello World";
    System.out.println("str = " + str);
    ReverseStrInterface solution = getSolution();
    String s = solution.reverseArr(str);
    System.out.println("s = " + s);
  }

  public static ReverseStrInterface getSolution() {
    return new ReverseStrSolutionV1();
  }

  public static class ReverseStrSolutionV1 implements ReverseStrInterface {

    @Override
    public String reverseArr(String input) {
      char[] chars = input.toCharArray();
      int l = 0;
      int r = chars.length - 1;
      char tmp;
      while (l <= r) {
        tmp = chars[r];
        chars[r] = chars[l];
        chars[l] = tmp;
        l++;
        r--;
      }
      return new String(chars);
    }
  }

  public interface ReverseStrInterface {

    String reverseArr(String input);
  }
}
