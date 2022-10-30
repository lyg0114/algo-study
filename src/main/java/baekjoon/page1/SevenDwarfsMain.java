package baekjoon.page1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author : iyeong-gyo
 * @package : baekjoon
 * @since : 2022/09/06
 * <p>
 * <p>
 * 1. 9명의  난쟁이의 키를 숫자를 입력받는다. 2. 9명 중 7명을 뽑는다. 3. 총 합이 100이 되는 경우를 찾는다.
 */
public class SevenDwarfsMain {
  private List<Integer> dwartTalls = new ArrayList<Integer>();
  private Stack<Integer> dwartTallIndexs = new Stack<Integer>();
  private int EXTRACT_DATA_COUNT = 7;

  public static void main(String[] args) {
    SevenDwarfsMain dwartTalls = new SevenDwarfsMain();
    dwartTalls.extracted();
    dwartTalls.extractSevenDwarfs(-1);
  }

  public void extractSevenDwarfs(int start) {
    if (dwartTallIndexs.size() == EXTRACT_DATA_COUNT) {
      extractDwarfs();
      return;
    }

    for (int i = start + 1; i < dwartTalls.size(); i++) {
      dwartTallIndexs.push(i);
      extractSevenDwarfs(i);
      dwartTallIndexs.pop();
    }
    return;
  }

  private void extractDwarfs() {
    int totalTallsSum = 0;
    for (int i = 0; i < dwartTallIndexs.size(); i++) {
      totalTallsSum += dwartTalls.get(dwartTallIndexs.get(i));
    }

    if (totalTallsSum == 100) {
      for (int i = 0; i < dwartTallIndexs.size(); i++) {
        System.out.print(dwartTalls.get(dwartTallIndexs.get(i)) + " ");
      }
      System.out.println("");
      System.out.println("totalTallsSum = " + totalTallsSum);
    }
  }

  public void extracted() {
    Scanner scanner = new Scanner(System.in);
    for (int i = 0; i < 9; i++) {
      dwartTalls.add(scanner.nextInt());
    }
  }
}
