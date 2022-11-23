package baekjoon.page1.pocketmon;

import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.page1
 * @since : 2022/11/15
 */
public class PokeyMon1620A {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int N = Integer.parseInt(scan.next());
    int M = Integer.parseInt(scan.next());
    String strarr[] = new String[N];
    for (int i = 0; i < N; i++) {
      strarr[i] = scan.next();
    }
    String asks[] = new String[M];
    for (int j = 0; j < M; j++) {
      asks[j] = scan.next();
    }
    for (int k = 0; k < M; k++) {
      try {
        int index = Integer.parseInt(asks[k]);
        if (index > 0) {
          System.out.println(strarr[index - 1]);
        }
      } catch (NumberFormatException ex) {
      } finally {
        for (int i = 0; i < N; i++) {
          if (asks[k].equals(strarr[i])) {
            System.out.println(i + 1);
          }
        }
      }
    }
  }
}
