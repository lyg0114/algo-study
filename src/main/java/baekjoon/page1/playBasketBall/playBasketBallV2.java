package baekjoon.page1.playBasketBall;

import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.page1.playBasketBall
 * @since : 2022/11/07
 */
public class playBasketBallV2 {

  public static void main(String[] args) {
    Scanner scan = getScanner();
    int count = Integer.parseInt(scan.next());
    int [] cnt = new int[26];
    if (count < 1 || count > 150) {
      return;
    }

    for (int i = 0; i < count; i++) {
      String str = scan.next();
      char[] s = str.toCharArray();
      cnt[s[0] - 97] ++;
    }

    for (int i = 0; i < 26; i++) {
      if(cnt[i] > 5){
        System.out.println((char)(i+97));
      }
    }
  }

  private static Scanner getScanner() {
    return new Scanner(System.in);
  }
}
