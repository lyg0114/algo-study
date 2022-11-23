package baekjoon.page1.palindrome;

import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.page1
 * @since : 2022/11/23
 */
public class palindrome_1213_2 {

  public static void main(String[] ars) {
    Scanner scan = new Scanner(System.in);
    String inputStr = scan.next();
    int[] ints = convertStringToCountingArray(inputStr);
    for (int i = 'Z'; i >= 'A'; i--) {
      System.out.println((char) i + " : " + ints[i]);
    }
  }

  public static int[] convertStringToCountingArray(String inputStr) {
    int[] result = new int[200];
    for (int i = 0; i < inputStr.length(); i++) {
      result[inputStr.charAt(i)] += 1;
    }
    return result;
  }
}
