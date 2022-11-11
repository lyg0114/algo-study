package baekjoon.page1;

import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.page1
 * @since : 2022/11/11
 * <p>
 * 1. 온도값 배열(N)이 주어진다. 2. 며칠의 값(M)이 주어진다.
 */
public class Sequence_2559 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int totalCount = Integer.parseInt(scanner.next());
    int temp[] = new int[totalCount];
    int gapCount = Integer.parseInt(scanner.next());
    for (int i = 0; i < totalCount; i++) {
      temp[i] = Integer.parseInt(scanner.next());
    }
    int startPoint = 0;
    int currentSum = 0;
    int tmpSum = 0;
    int endPoint = gapCount;

    while (endPoint < temp.length) {
      for (int i = startPoint; i < endPoint; i++) {
        tmpSum += temp[i];
      }
      if (tmpSum > currentSum) {
        currentSum = tmpSum;
      }
      tmpSum = 0;
      startPoint++;
      endPoint++;
    }

    System.out.println(currentSum);
  }
}
