package baekjoon.page5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.greedy.q3190
 * @since : 22.02.24
 */

/*
- 백트랭킹 : 선택된 바퀴를 기준으로 왼쪽으로 한번, 오른쪽으로 한번 로직을 전개

 - N 극 : 0
 - S 극 : 1
 - 시계방향    :  1    =>    오른쪽으로 shift
 - 반 시계방향 : -1:   =>    왼쪽으로 shift

 - 왼쪽의 2번이랑 오른쪽으 6번이 만나는 면적
 - (n번 바퀴의 2번 인덱스와 n+1 번 바퀴의 6번 인덱스가 맡닽는다)
 - 회전하지 않으면 그 뒤의바퀴도 더이상 회전하지 않는다

    10{1}011[1]1
    01{1}111[0]1
    11{0}011[1]0
    00{0}000[1]0
*/
public class Question15662 {

  public static void main(String[] args) throws IOException {
    Solution solution = new SolutionImpl();
    solution.doMain();
  }

  static class SolutionImpl implements Solution {
    static class rotateInfo {
      int gearNum, dir;
      public rotateInfo(int gearNum, int dir) {
        this.gearNum = gearNum - 1;
        this.dir = dir;
      }
    }

    static class Gear {
      int gearNum;
      List<Integer> slices;
      public Gear(int gearNum, List<Integer> slices) {
        this.gearNum = gearNum;
        this.slices = slices;
      }
      public void rotate(int dir) {
        if (dir > 0) { right(); }
        else { left(); }
      }

      private void left() {
        if (this.slices.size() <= 1) { return; }
        Integer firstElement = this.slices.remove(0);
        this.slices.add(this.slices.size(), firstElement);
      }

      private void right() {
        if (this.slices.size() <= 1) { return; }
        Integer lastElement = this.slices.remove(this.slices.size() - 1);
        this.slices.add(0, lastElement);
      }
    }

    private int T;
    private int k;
    private int res = 0;
    List<Gear> gears = new ArrayList<>();

    @Override
    public void doMain() throws IOException {
      Scanner sc = new Scanner(System.in);
      T = sc.nextInt();
      gears = new ArrayList<>();
      for (int i = 0; i < T; i++) {
        List<Integer> slice = new ArrayList<>();
        String[] split = sc.next().split("");
        for (String s : split) {
          slice.add(Integer.valueOf(s));
        }
        gears.add(new Gear(i, slice));
      }
      k = sc.nextInt();

      List<rotateInfo> rotateInfos = new ArrayList<>();
      for (int i = 0; i < k; i++) {
        rotateInfos.add(new rotateInfo(sc.nextInt(), sc.nextInt()));
      }

      for (rotateInfo rInfo : rotateInfos) {
        Gear gear = gears.get(rInfo.gearNum);
        gear.rotate(rInfo.dir);
        leftSide(rInfo.gearNum - 1, gear, rInfo.dir);
        gear.rotate(rInfo.dir * -1);
        gear.rotate(rInfo.dir);
        rightSide(rInfo.gearNum + 1, gear, rInfo.dir);
      }

      for (Gear gear : gears) { res += gear.slices.get(0); }
      System.out.println(res);
    }

    private void leftSide(int gearNum, Gear rightGear, int prevDir) {
      if (gearNum < 0) { return; }
      Gear gear = gears.get(gearNum);
      if (prevDir > 0) { // 이전바퀴가 시계방향으로 돌경우
        if (gear.slices.get(2).equals(rightGear.slices.get(7))) {
          //이전 바퀴는 이미 한번 돌았기 때문에 현재 gear의 [2]번 인덱스와 rightGear의 [7]번 인덱스를 비교
          //두개의 값이 같다면 현재 gear는 돌리지 않고 return
          return;
        } else {
          //두개의 값이 다르다면 현재바퀴는 (prevDir * -1) 방향으로 회전 후 다시 재귀 호출
          int curDir = prevDir * -1;
          gear.rotate(curDir);
          leftSide(gearNum - 1, gear, curDir);
        }
      } else { // 이전바퀴가 반 시계방향으로 돌경우
        if (gear.slices.get(2).equals(rightGear.slices.get(5))) {
          // 이전 바퀴는 이미 한번 돌았기 때문 현재 gear의 [2]번 인덱스와 rightGear의 [5]번 인덱스를 비교
          //두개의 값이 같다면 현재 gear는 돌리지 않고 return
          return;
        } else {
          //두개의 값이 다르다면 현재바퀴는 (prevDir * -1) 방향으로 회전 후 다시 재귀 호출
          int curDir = prevDir * -1;
          gear.rotate(curDir);
          leftSide(gearNum - 1, gear, curDir);
        }
      }
    }

    private void rightSide(int gearNum, Gear leftGear, int prevDir) {
      if (gearNum > gears.size() - 1) { return; }
      Gear gear = gears.get(gearNum);
      if (prevDir > 0) { // 이전바퀴가 시계방향으로 돌경우
        if (gear.slices.get(6).equals(leftGear.slices.get(3))) {
          //이전 바퀴는 이미 한번 돌았기 때문에 현재 gear의 [6]번 인덱스와 leftGear의 [3]번 인덱스를 비교
          //두개의 값이 같다면 현재 gear는 돌리지 않고 return
          return;
        } else {
          //두개의 값이 다르다면 현재 gear는 (prevDir * -1) 방향으로 회전 후 다시 재귀 호출
          int curDir = prevDir * -1;
          gear.rotate(curDir);
          rightSide(gearNum + 1, gear, curDir);
        }
      } else { // 이전바퀴가 반 시계방향으로 돌았다.
        if (gear.slices.get(6).equals(leftGear.slices.get(1))) {
          //이전 바퀴는 이미 한번 돌았기 때문에 현재 gear의 [6]번 인덱스와 leftGear의 [1]번 인덱스를 비교
          //두개의 값이 같다면 현재 gear는 돌리지 않고 return
          return;
        } else {
          //두개의 값이 다르다면 현재 gear는 (prevDir * -1) 방향으로 회전 후 다시 재귀 호출
          int curDir = prevDir * -1;
          gear.rotate(curDir);
          rightSide(gearNum + 1, gear, curDir);
        }
      }
    }
  }

  interface Solution {

    void doMain() throws IOException;
  }
}
