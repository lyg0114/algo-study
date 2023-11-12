package leetcode.topinterview.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView
 * @link
 * https://leetcode.com/problems/gas-station/description/?envType=featured-list&envId=top-interview-questions%3FenvType%3Dfeatured-list&envId=top-interview-questions
 * @since : 12.11.23 - rotate entire loop means gastank shoud not be negative. - find StartPoint
 */
public class GasStation134 {

  public static void main(String[] args) {
    SolutionV2 solution = new SolutionV2();
    int gas[] = {2, 3, 4};
    int coast[] = {3, 4, 3};
//    int gas[] = {1, 2, 3, 4, 5};
//    int coast[] = {3, 4, 5, 1, 2};
    int result = solution.canCompleteCircuit(gas, coast);
    System.out.println("result = " + result);
  }

  static class SolutionV2 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
      int totalGas = 0;  // 전체 가스 양
      int currentGas = 0;  // 현재 가스 양
      int startStation = 0;  // 출발 지점

      for (int i = 0; i < gas.length; i++) {
        totalGas += gas[i] - cost[i];
        currentGas += gas[i] - cost[i];

        // 만약 현재 가스가 음수가 되면 출발 지점을 현재 지점의 다음으로 바꿔줌
        if (currentGas < 0) {
          currentGas = 0;
          startStation = i + 1;
        }
      }

      // 전체 가스가 음수면 순환이 불가능한 경우이므로 -1 반환
      if (totalGas < 0) {
        return -1;
      } else {
        return startStation;
      }
    }
  }

  static class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
      if (gas.length != cost.length) {
        return -1;
      }
      int n = gas.length;
      List<Integer> startPoint = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        if (gas[i] - cost[i] > -1) {
          startPoint.add(i);
        }
      }
      if (startPoint.isEmpty()) {
        return -1;
      }

      int gasTank;
      int moveCnt;
      int curIndex;
      for (Integer startIndex : startPoint) {
        gasTank = 0;
        moveCnt = 0;
        curIndex = startIndex;
        while (moveCnt < n) {
          gasTank = gasTank + gas[curIndex] - cost[curIndex];
          if (gasTank < 0) {
            break;
          }
          if (curIndex == n - 1) {
            curIndex = 0;
          } else {
            curIndex++;
          }
          moveCnt++;
        }
        if (moveCnt == n) {
          return startIndex;
        }
      }
      return -1;
    }
  }
}



