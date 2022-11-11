package baekjoon.page1.sequence;

import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.page1
 * @since : 2022/11/11
 * <p>
 */
public class SequenceUsingPSum_2559 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.next());
    int k = Integer.parseInt(scanner.next());
    int arr[] = new int[n];
    int psum[] = new int[100];
    for (int i = 1; i <= arr.length; i++) {
      int inputNum = Integer.parseInt(scanner.next());
      psum[i] = psum[i - 1] + inputNum;
    }
    int max = 0;
    int tmp = 0;
    for (int i = k; i < arr.length; i++) {
      tmp = psum[i] - psum[i - k];
      if(max < tmp){
        max = tmp;
      }
    }
    System.out.println("max = " + max);
  }
}
