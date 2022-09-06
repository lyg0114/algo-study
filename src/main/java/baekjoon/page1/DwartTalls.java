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
public class DwartTalls {

  private List<Integer> dwartTalls = new ArrayList<Integer>();
  private Stack<Integer> dwartTallCombinations = new Stack<Integer>();
  private int totalTallsSum;

  private int EXTRACT_DATA_COUNT = 7;

  public int extractSevenDwarfs(int start) {
    if (dwartTallCombinations.size() == EXTRACT_DATA_COUNT) {
      return dwartTalls.get(start);
    }

    for (int i = start + 1; i < dwartTalls.size(); i++) {
      dwartTallCombinations.push(i);
      totalTallsSum += extractSevenDwarfs(i);
      dwartTallCombinations.pop();
    }
    return totalTallsSum;
  }

  public void extracted() {
    Scanner scanner = new Scanner(System.in);
    int v1 = scanner.nextInt();
    dwartTalls.add(v1);
    int v2 = scanner.nextInt();
    dwartTalls.add(v2);
    int v3 = scanner.nextInt();
    dwartTalls.add(v3);
    int v4 = scanner.nextInt();
    dwartTalls.add(v4);
    int v5 = scanner.nextInt();
    dwartTalls.add(v5);
    int v6 = scanner.nextInt();
    dwartTalls.add(v6);
    int v7 = scanner.nextInt();
    dwartTalls.add(v7);
    int v8 = scanner.nextInt();
    dwartTalls.add(v8);
    int v9 = scanner.nextInt();
    dwartTalls.add(v9);
  }


}
