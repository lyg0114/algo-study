package baekjoon.page1;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.page1
 * @since : 2022/11/17
 * 경우의 수 문제
 */
public class PassionKingMIssSin_9375 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int t = Integer.parseInt(scanner.next());
    while (t-- > 0) {
      HashMap<String, Integer> map = new HashMap<String, Integer>();
      int n = Integer.parseInt(scanner.next());
      for (int i = 0; i < n; i++) {
        String a = scanner.next();
        String b = scanner.next();
        if(map.containsKey(b)){
          map.replace(b,map.get(b) + 1);
        }
        if(!map.containsKey(b)){
          map.put(b, 1);
        }
      }
      Long ret = 1L;
      for (String c : map.keySet()) {
        ret *= map.get(c) + 1;
      }
      ret --;
      System.out.println("ret = " + ret);
    }
  }
}
