package baekjoon.page1;

import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.page1
 * @since : 2022/11/02
 */
public class CheckPalendrom {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String inputStr = input.next();
    char[] inputCharArray = inputStr.toCharArray();
    CheckPalendrom checkPalendrom = new CheckPalendrom();
    boolean palendrom = checkPalendrom.isPalendrom(inputCharArray);
    System.out.println("palendrom = " + palendrom);
  }

  public boolean isPalendrom(char[] inputCharArr) {
    int middle = inputCharArr.length / 2;
    for (int i = 0; i < middle; i++) {
      if(inputCharArr[i] != inputCharArr[(inputCharArr.length-1) - i])
        return false;
    }
    return true;
  }
}
