package baekjoon.page5;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.greedy
 * @since : 16.11.23
 */
public class SumOfTwo3273 {

  public static void main(String[] args) {
    SolutionInterface solution = getSolution();
    solution.solution();
  }

  private static SolutionInterface getSolution() {
    return new SolutionV2();
  }

  static class SolutionV2 implements SolutionInterface {

    @Override
    public void solution() {
      Scanner sc = new Scanner(System.in);
      int[] nums = new int[sc.nextInt()];
      for (int i = 0; i < nums.length; i++) nums[i] = sc.nextInt();
      int X = sc.nextInt();
      Arrays.sort(nums);
      int l = 0, r = nums.length - 1, ans = 0;
      while (l < r) {
        if (nums[l] + nums[r] == X){ ans++; l++; r--;}
        else if (nums[l] + nums[r] > X) {r--;}
        else if(nums[l] + nums[r] < X) {l++;}
      }
      System.out.println(ans);
    }
  }

  static class SolutionV1 implements SolutionInterface {

    @Override
    public void solution() {
      Scanner scanner = new Scanner(System.in);
      int N = scanner.nextInt();
      int[] nums = new int[N];
      int cur;
      for (int i = 0; i < nums.length; i++) {
        cur = scanner.nextInt();
        nums[i] = cur;
      }
      int X = scanner.nextInt();
      int result = 0;
      for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
          if (nums[i] + nums[j] == X) {
            result++;
          }
        }
      }
      System.out.println(result);
    }
  }

  interface SolutionInterface {

    void solution();
  }

}
