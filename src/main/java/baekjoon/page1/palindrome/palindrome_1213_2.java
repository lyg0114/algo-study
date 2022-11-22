package baekjoon.page1.palindrome;

import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.page1
 * @since : 2022/11/23
 */
public class palindrome_1213_2 {
  public static void main(String [] ars){
    Scanner scan = new Scanner(System.in);
    String inputStr = scan.next();
    int[] ints = convertStringToCountingArray(inputStr);
    for (int i = 0; i < ints.length; i++) {
      System.out.println("i = " + i);
      System.out.println(ints[i]);
    }
  }

  public static int[] convertStringToCountingArray(String inputStr) {
    int[] result = new int[inputStr.length()];
    for (int i = 0; i < inputStr.length(); i++) {
      int targetNum = inputStr.charAt(i);
      result[targetNum - 97] += 1;
    }
    return result;
  }
}
