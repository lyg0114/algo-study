package baekjoon.page5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.greedy
 * @name : 멀티탭 스케쥴링
 * @since : 28.12.23
 */
public class Question1700 {

  public static void main(String[] args) throws IOException {
    Solution solution = new SolutionImpl();
    solution.doMain();
  }

  static class SolutionImpl implements Solution {

    @Override
    public void doMain() throws IOException {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt(); // 최대 멀티탭 개수
      int k = scanner.nextInt(); // 전자기기의 총 개수
      int[] device = new int[104]; // 전자기기 종류를 저장하는 배열
      int[] isPluged = new int[104]; // 각 종류의 전자기기가 꽂혀있는지 여부를 나타내는 배열
      int cnt = 0; // 멀티탭을 뽑아야 하는 횟수
      List<Integer> tab = new ArrayList<>(); // 현재 꽂혀있는 전자기기 목록

      for (int i = 0; i < k; i++) {
        device[i] = scanner.nextInt();
      }

      for (int i = 0; i < k; i++) {
        if (isPluged[device[i]] == 0) { // 현재 고려 중인 전자기기가 아직 꽂혀있지 않은 경우
          if (tab.size() == n) { // 멀티탭이 꽉 찬 경우
            int lastIdx = 0; //현재 꽂혀있는 전자기기 중에서 가장 나중에 사용된 전자기기의 인덱스
            int pos = 0; // 교체할 전자기기의 종류

            for (int _a : tab) { // 현재 꽂혀있는 전자기기 중 가장 나중에 사용되는 것을 찾음
              int herePick = Integer.MAX_VALUE; // 현재 고려 중인 전자기기가 꽂힌 이후에 사용된 마지막 인덱스
              for (int j = i + 1; j < k; j++) { // 현재 고려 중인 전자기기 이후에 사용되는 인덱스를 찾음
                if (_a == device[j]) {
                  herePick = j;
                  break;
                }
              }

              if (lastIdx < herePick) { // 여러 전자기기 중에서 가장 나중에 사용되는 것을 선택
                lastIdx = herePick;
                pos = _a;
              }
            }

            // 교체할 전자기기를 뽑고, 새로운 전자기기를 꽂음
            isPluged[pos] = 0;
            tab.remove(Integer.valueOf(pos));
            cnt++;
          }

          // 현재 고려 중인 전자기기를 꽂음
          tab.add(device[i]);
          isPluged[device[i]] = 1;
        }
      }

      System.out.println(cnt);
    }
  }

  interface Solution {

    void doMain() throws IOException;
  }
}
