package baekjoon.page5;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.page5
 * @since : 27.02.24
 */
public class Question1911 {
  public static void main(String[] args) throws IOException {
    Solution solution = new SolutionImplV2();
    solution.doMain();
  }

  static class SolutionImplV2 implements Solution {
    static class Range {
      int start;
      int end;
      public Range(int start, int end) {
        this.start = start;
        this.end = end;
      }
    }

    int countOfWaterFall, lengthOfBoard, index, ret, countOfBoard;

    @Override
    public void doMain() throws IOException {
      Scanner scanner = new Scanner(System.in);
      countOfWaterFall = scanner.nextInt(); // 웅덩이 갯수
      lengthOfBoard = scanner.nextInt(); // 널빤지 길이

      Range[] ranges = new Range[countOfWaterFall];
      for (int i = 0; i < countOfWaterFall; i++) {
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        ranges[i] = new Range(start, end);
      }

      Arrays.sort(ranges, Comparator.comparingInt(x -> x.start));

      for (int i = 0; i < countOfWaterFall; i++) {
        Range curRange = ranges[i];

        if (curRange.end <= index) { // 이미 웅덩에 널빤지작업이 완료된 경우
          continue;
        }

        if (index < curRange.start) { // 현재 idx 가 웅덩이의 시작점 (curRange.start) 보다 작은 경우
          countOfBoard =
                    ((curRange.end - curRange.start) / lengthOfBoard )              // (웅덩이 길이 / 널빤지 길이)
                  + ((curRange.end - curRange.start) % lengthOfBoard != 0 ? 1 : 0); // (웅덩이 길이 % 널빤지 길이) 가 0인지 0이 아닌지 판별

          index = curRange.start + (countOfBoard * lengthOfBoard);

        } else { // 현재 idx 가 웅덩이의 시작점(curRange.start) 보다 크거나 같은 경우
          countOfBoard =
                ((curRange.end - index) / lengthOfBoard)
              + ((curRange.end - index) % lengthOfBoard != 0 ? 1 : 0);

          index = index + (countOfBoard * lengthOfBoard);
        }

        ret += countOfBoard;

      }

      System.out.println(ret);
    }
  }

  interface Solution {
    void doMain() throws IOException;
  }
}
