package baekjoon.page1.playBasketBall;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.page1
 * @since : 2022/11/06 total Alpabet Count : 26
 * A : 65 , Z : 90 a : 97 , z : 122
 * Solve using ASCII
 * code
 */
public class PlayBasketBall {
  public static void main(String[] args) {
    Scanner scan = getScanner();
    int count = Integer.parseInt(scan.next());
    if (count < 1 || count > 150) {
      return;
    }

    HashMap<Character, Integer> resultMap = new HashMap<>();
    for (int i = 0; i < count; i++) {
      String str = scan.next();
      char[] chars = str.toCharArray();
      if (chars.length > 30) {
        return;
      }

      if (resultMap.get(chars[0]) == null) {
        resultMap.put(chars[0], 1);
      } else {
        resultMap.replace(chars[0], resultMap.get(chars[0]) + 1);
      }
    }

    for (Character character : resultMap.keySet()) {
      Integer cnt = resultMap.get(character);
      if (cnt > 5) {
        System.out.println(character);
      }
    }
  }

  private static Scanner getScanner() {
    return new Scanner(System.in);
  }
}
