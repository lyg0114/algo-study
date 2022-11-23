package baekjoon.page1.palindrome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    int[] cnt = convertStringToCountingArray(inputStr);
    int oddFlag = 0;
    char mid = 0;
    String ret = "";
    for (int i = 'Z'; i >= 'A'; i--) {
//      System.out.println((char) i + " : " + ints[i]);
      if (cnt[i] > 0) {
        if (cnt[i] % 2 == 1) {
          mid = (char) i;
          oddFlag++;
          cnt[i]--;
        }
      }
      if (oddFlag == 2) {
        System.out.println("I'm Sorry Hansoo");
        break;
      }
      for (int j = 0; j < cnt[i]; j += 2) {
        ret = String.valueOf((char) i) + ret;
        ret += String.valueOf((char) i);
      }
    }
    if (mid > 0) {
      String before = ret.substring(0, ret.length() / 2);
      String after = ret.substring(ret.length() / 2, ret.length());
      System.out.println(before + mid + after);
    } else {
      System.out.println(ret);
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
