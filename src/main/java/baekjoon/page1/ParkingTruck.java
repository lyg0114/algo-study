package baekjoon.page1;

import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.page1
 * @since : 2022/10/31
 */
public class ParkingTruck {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int A = Integer.parseInt(scan.next());
    int B = Integer.parseInt(scan.next());
    int C = Integer.parseInt(scan.next());
    int ret = 0;

    int arr[] = new int[104];

    for (int i = 0; i < 3; i++) {
      int a = Integer.parseInt(scan.next());
      int b = Integer.parseInt(scan.next());
      for (int j = a; j < b; j++) { arr[j] += 1; }
    }

    for (int k = 1; k < 10; k++) {
      if (arr[k] > 0) {
        if (arr[k] == 1) ret += A;
        else if (arr[k] == 2) ret += B * 2;
        else if (arr[k] == 3) ret += C * 3;
      }
    }
    System.out.println(ret);
  }
}
