package baekjoon.page1.countofAlpabet;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.page1
 * @since : 2022/10/30 알파벳 소문자로만 이루어진 단어 S가 주어진다. 각 알파벳이 단어에 몇 개가 포함되어 있는지 구하는 프로그램을 작성하시오. ASCII
 * Code
 * <p>
 * total Alpabet Count : 26 A : 65 , Z : 90 a : 97 , z : 122
 * Solve using ASCII code
 */
public class CountOfAlpabet2 {
  public static void main(String[] args) {
    CountOfAlpabet2 countOfAlpabet2 = new CountOfAlpabet2();
    String inputStr = "yglee";
    int[] inputArray = countOfAlpabet2.convertStringToArray(inputStr);
    for (int i = 0; i < inputArray.length; i++) {
      System.out.println((char)(i + 97) + ":" + inputArray[i]);
    }
  }

  public int[] convertStringToArray(String inputStr) {
    int[] result = new int[26];
    for (int i = 0; i < inputStr.length(); i++) {
      int targetNum = inputStr.charAt(i);
      result[targetNum - 97] += 1;
    }
    return result;
  }
}
