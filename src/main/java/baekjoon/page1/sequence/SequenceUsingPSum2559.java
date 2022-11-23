package baekjoon.page1.sequence;

import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.page1
 * @since : 2022/11/11
 * <p>
 */
public class SequenceUsingPSum2559 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int totalNum = Integer.parseInt(scanner.next());
    int intervalIndex = Integer.parseInt(scanner.next());
    int arr[] = new int[totalNum];
    int psum[] = new int[totalNum + 1];
    for (int i = 1; i <= arr.length; i++) {
      int inputNum = Integer.parseInt(scanner.next());
      psum[i] = psum[i - 1] + inputNum;
    }
    int max = 0;
    int tmp = 0;
    for (int i = intervalIndex; i < arr.length; i++) {
      tmp = psum[i] - psum[i - intervalIndex];
      if(max < tmp){
        max = tmp;
      }
    }
    System.out.println("max = " + max);
  }
}
