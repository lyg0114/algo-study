package baekjoon.page5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.greedy
 * @since : 26.12.23
 */
public class Question1931 {

  public static void main(String[] args) throws IOException {
    Solution solution = new SolutionList();
    solution.doMain();
  }

  static class SolutionList implements Solution {
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
      for (int i = 0; i < totalCnt; i++) {
        meetings.add(new Meeting(sc.nextInt(), sc.nextInt()));
      }
      meetings.sort(Comparator.comparingInt(Meeting::getEnd)
          .thenComparingInt(Meeting::getStart));
      int cnt = 0;
      int end = 0;
      for (Meeting meeting : meetings) {
        if (end <= meeting.getStart()) {
          end = meeting.getEnd();
          cnt++;
        }
      }
      System.out.println(cnt);
    }
  }

  static class SolutionArray implements Solution {
    @Override
    public void doMain() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());
      int[][] time = new int[N][2];
      StringTokenizer st;
      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        time[i][0] = Integer.parseInt(st.nextToken()); // 시작
        time[i][1] = Integer.parseInt(st.nextToken()); // 종료
      }

      Arrays.sort(time, (o1, o2) -> {
        if (o1[1] == o2[1]) {
          return o1[0] - o2[0];
        }
        return o1[1] - o2[1];
      });

      int cnt = 0;
      int end = 0;
      for (int i = 0; i < N; i++) {
        if (end <= time[i][0]) { // start
          end = time[i][1]; //end
          cnt++;
        }
      }
      System.out.println(cnt);
    }
  }

interface Solution {

  void doMain() throws IOException;
}
}
