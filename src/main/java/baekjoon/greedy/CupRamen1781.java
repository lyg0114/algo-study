package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.greedy
 * @since : 21.12.23
 */
public class CupRamen1781 {

  public static void main(String[] args) {
  }

  static class SolutionV1 implements Solution {

    @Override
    public void doMain() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String str = br.readLine();
      String boom = br.readLine();
    }
  }

  interface Solution {
    void doMain() throws IOException;
  }
}
