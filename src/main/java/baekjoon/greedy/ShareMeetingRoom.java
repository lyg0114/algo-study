package baekjoon.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.greedy
 * @since : 12.11.23
 */
public class ShareMeetingRoom {

  public static void main(String[] args) {
    ArrayList<Meeting> meetings = new ArrayList<>();
    int[] start = {1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12};
    int[] end = {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

    for (int i = 0; i < start.length; i++) {
      meetings.add(new Meeting(start[i], end[i]));
    }

    Solution sol = new Solution();
    List<Meeting> selectedMeetings = sol.solution(meetings);
    System.out.println("최대 회의 수: " + selectedMeetings.size());
    System.out.println("선택된 회의 정보:");
    for (Meeting meeting : selectedMeetings) {
      System.out.println("시작 시간: " + meeting.start + ", 종료 시간: " + meeting.end);
    }
  }

  static class Solution {

    public List<Meeting> solution(List<Meeting> meetings) {
      meetings.sort(Comparator.comparingInt(Meeting::getEnd));
      List<Meeting> selectedMeetings = new ArrayList<>();
      if (meetings.isEmpty()) {
        return selectedMeetings;
      }

      // 첫 번째 회의는 무조건 선택
      selectedMeetings.add(meetings.get(0));
      Meeting lastMeeting = meetings.get(0);

      // 종료 시간이 겹치지 않는 경우에만 회의 선택
      for (int i = 1; i < meetings.size(); i++) {
        Meeting currentMeeting = meetings.get(i);
        if (currentMeeting.start >= lastMeeting.end) {
          selectedMeetings.add(currentMeeting);
          lastMeeting = currentMeeting;
        }
      }

      return selectedMeetings;
    }
  }

  static class Meeting {

    int start;
    int end;

    public Meeting(int start, int end) {
      this.start = start;
      this.end = end;
    }

    public int getEnd() {
      return end;
    }
  }
}
