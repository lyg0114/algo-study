package baekjoon.page5;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.greedy
 * @since : 16.01.24
 */
public class Question17406 {

  public static void main(String[] args) throws IOException {
    Solution solution = new SolutionImpl();
    solution.doMain();
  }

  static class SolutionImpl implements Solution {

    @Override
    public void doMain() throws IOException {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
    }
  }

  interface Solution {

    void doMain() throws IOException;
  }
}
