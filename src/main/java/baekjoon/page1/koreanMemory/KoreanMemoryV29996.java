package baekjoon.page1.koreanMemory;

import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon
 * @since : 2022/11/08
 * <p>
 * 1. * 첫번째 입력값에 * 있는지 체크
 * 2. 없으면 프로그램 종료
 * 3. 있다면 * 기준으로 앞뒤로 split
 * 4. 두개의 split된 문자열을 비교
 * 5. 서로 다르면 * 프로그램 종료
 * 6. 뒤이어 입력되는 텍스트의 맨앞, 맨뒤 비교
 */
public class KoreanMemoryV29996 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int count = Integer.parseInt(scan.next());
    String rex = scan.next();
    if (!rex.contains("*")) {
      throw new RuntimeException("* 가 없습니다.");
    }
    String[] split = rex.split("\\*");
    String preFix = split[0];
    String subFix = split[1];
    for (int i = 0; i < count; i++) {
      String inputStr = scan.next();
      if(preFix.length() + subFix.length() > inputStr.length()){
        if (preFix.equals(inputStr.substring(0, preFix.length())) &&
            subFix.equals(inputStr.substring(inputStr.length() - subFix.length(), inputStr.length()))
        ) {
          System.out.println("DA");
        } else {
          System.out.println("NE");
        }
      } else {
        System.out.println("NE");
      }
    }
  }
}
