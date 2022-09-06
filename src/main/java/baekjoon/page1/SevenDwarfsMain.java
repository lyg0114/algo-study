package baekjoon.page1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon
 * @since : 2022/09/06
 * <p>
 * <p>
 * 1. 9명의  난쟁이의 키를 숫자를 입력받는다. 2. 9명 중 7명을 뽑는다. 3. 총 합이 100이 되는 경우를 찾는다.
 */
public class SevenDwarfsMain {

  public static void main(String[] args) {
    DwartTalls dwartTalls = new DwartTalls();
    dwartTalls.extracted();
    int result = dwartTalls.extractSevenDwarfs(-1);
    System.out.println("result = " + result);
  }

}
