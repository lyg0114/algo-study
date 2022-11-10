package baekjoon.page1.koreanMemory;

import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon
 * @since : 2022/11/08
 * <p>
 * 1. * 첫번째 입력값에 * 있는지 체크 2. 없으면 프로그램 종료 3. 있다면 * 기준으로 앞뒤로 split 4. 두개의 split된 문자열을 비교 5. 서로 다르면
 * 프로그램 종료 6. 뒤이어 입력되는 텍스트의 맨앞, 맨뒤 비교
 */
public class KoreanMemoryV2_9996 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int count = Integer.parseInt(scan.next());
    String rex = scan.next();
    if (!rex.contains("*")) {
      throw new RuntimeException("* 가 없습니다.");
    }
    String[] split = rex.split("\\*");
    if (!split[0].equals(split[0])) {
      throw new RuntimeException("입력된 문자열이 일치하지 않습니다.");
    }
    char[] prePix = split[0].toCharArray();
    char[] postPix = split[1].toCharArray();
    String result[] = new String[count];
    for (int i = 0; i < count; i++) {
      String inputStr = scan.next();
      char[] inputChars = inputStr.toCharArray();
      for (int j = 0; j < prePix.length; j++) {
        if (inputChars[j] != prePix[j]) {
          result[i] = "NE";
        }
      }

      String postPixStr = postPix.toString();
      char postPixResultStr [] = new char[postPix.length];
      for (int k = inputChars.length - 1; k > inputChars.length - postPix.length ; k--) {
        postPixResultStr[k] = inputChars[k];
      }
      String s = postPixResultStr.toString();
      if(!postPixStr.equals(s))
        result[i] = "NE";

      if (result[i] == null) {
        result[i] = "DA";
      }
    }
    for (String s : result) {
      System.out.println(s);
    }
  }
}
