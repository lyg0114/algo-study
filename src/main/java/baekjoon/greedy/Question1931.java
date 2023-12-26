package baekjoon.greedy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.greedy
 * @since : 26.12.23
 */
public class Question1931 {

  public static void main(String[] args) throws IOException {
    Solution solution = new SolutionV1();
    solution.doMain();
  }

  static class SolutionV1 implements Solution {
    static class Meeting {
      public final int start;
      public final int end;
      public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
      }
      public int getStart() { return start; }
      public int getEnd() { return end; }
    }

    @Override
    public void doMain() throws IOException {
      Scanner sc = new Scanner(System.in);
      int totalCnt = sc.nextInt();
      List<Meeting> meetings = new ArrayList<>();
      List<Meeting> results = new ArrayList<>();
      for (int i = 0; i < totalCnt; i++) {
        meetings.add(new Meeting(sc.nextInt(), sc.nextInt()));
      }
      meetings.sort(Comparator.comparingInt(Meeting::getEnd));
      int curEnd = 0;
      for (Meeting meeting : meetings) {
        if (results.isEmpty()) {
          results.add(meeting);
          curEnd = meeting.getEnd();
        } else if (meeting.getStart() >= curEnd) {
          results.add(meeting);
          curEnd = meeting.getEnd();
        }
      }
      System.out.println(results.size());
    }
  }

  interface Solution {
    void doMain() throws IOException;
  }
}
