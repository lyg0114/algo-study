package baekjoon.page1.Number1;

import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.page1
 * @since : 2022/12/03
 */
public class Number1V2 {

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.next());
    if (n % 2 == 0 || n % 5 == 0) {
      System.out.println("shut down");
      return;
    }
    int cnt = 1;
    int ret = 1;
    while (true) {
      if (cnt % n == 0) {
        System.out.println("ret = " + ret);
        break;
      } else {
        cnt = (cnt * 10) + 1;
        cnt %= n;
        ret ++;
      }
    }
  }

}
