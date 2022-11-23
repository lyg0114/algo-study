package baekjoon.page1.pocketmon;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.page1
 * @since : 2022/11/15
 */
public class PokeyMon1620B {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int N = Integer.parseInt(scan.next());
    int M = Integer.parseInt(scan.next());
    HashMap<String, Integer> mp = new HashMap<String, Integer>();
    HashMap<Integer, String> mp2 = new HashMap<Integer, String>();
    String strarr[] = new String[N];
    for (int i = 0; i < N; i++) {
      String s = scan.next();
      mp.put(s, i + 1);
      mp2.put(i + 1, s);
    }
    for (int j = 0; j < M; j++) {
      String str = scan.next();
      try {
        int i1 = Integer.parseInt(str);
        System.out.println(mp2.get(i1));
      } catch (NumberFormatException ex) {
        System.out.println(mp.get(str));
      }
    }
  }
}
