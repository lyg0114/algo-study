package baekjoon;
import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon
 * @since : 2022/11/08
 */
public class KoreanMemory_9996 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int count = Integer.parseInt(scan.next());
    String rex = scan.next();
    char[] rexChar = rex.toCharArray();
    char startStr = rexChar[0];
    char endStr = rexChar[rex.length() - 1];
    String[] result = new String[count];

    for (int i = 0; i < count; i++) {
      String str = scan.next();
      char[] chars = str.toCharArray();
      if (chars[0] == startStr && chars[chars.length - 1] == endStr) {
        result[i] = "DA";
      } else {
        result[i] = "NE";
      }
    }

    for (String s : result) {
      System.out.print(s + " ");
    }
  }
}
