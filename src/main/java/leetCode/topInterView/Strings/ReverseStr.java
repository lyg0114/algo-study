package leetCode.topInterView.Strings;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Strings
 * @since : 2023/06/02
 */
public class ReverseStr {

  public static void main(String[] args) {
    String str = "HelloWorld";
    System.out.println("str = " + str);
    char[] chars = str.toCharArray();
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

    for (int i = 0; i < chars.length; i++) {
      System.out.println("chars[i] = " + chars[i]);
    }

  }
}
