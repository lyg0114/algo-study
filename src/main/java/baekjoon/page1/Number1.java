package baekjoon.page1;

import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.page1
 * @since : 2022/12/03
 */
public class Number1 {

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.next());
    if (n % 2 == 0 && n % 5 == 0) {
      return;
    }

    int ret = calculate(n, 0, 0);
    System.out.println("ret = " + ret);

  }

  private static int calculate(int n, int i, int ret) {
    ret =  (ret + (int) Math.pow(10, i));
    if (ret % n == 0) {
      return i + 1;
    }
    return calculate(n, i + 1, ret);
  }
}
