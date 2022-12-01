package baekjoon.page1;

import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.page1
 * @since : 2022/11/30
 */
public class Multifly {
  private static Long A;
  private static Long B;
  private static Long C;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    A = Long.valueOf(scanner.next());
    B = Long.valueOf(scanner.next());
    C = Long.valueOf(scanner.next());
    System.out.println(go(A,B));
  }

  public static long go(Long A, Long B) {
    if (B == 1) {
      return A % C;
    }
    long ret = go(A, B / 2);
    ret = (ret * ret) % C;
    if (B % 2 > 0) {
      ret = (ret * A) % C;
    }
    return ret;
  }

}
