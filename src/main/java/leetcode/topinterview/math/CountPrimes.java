package leetcode.topinterview.math;

import java.util.Arrays;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Math
 * @url : https://leetcode.com/explore/featured/card/top-interview-questions-easy/102/math/744/
 * @since : 2023/05/02
 */
public class CountPrimes {

  public static void main(String[] args) {
    CountPrimesPlayGround solution = new CountPrimesPlayGround();
    System.out.println(solution.countPrimes(10));
  }

  public static class CountPrimesPlayGround implements CountPrimesInterface {

    @Override
    public int countPrimes(int n) {
      return 0;
    }
  }

  public static class CountPrimesSolution2 implements CountPrimesInterface {

    @Override
    public int countPrimes(int n) {
      n -= 1;
      if (n < 0 || n == 0 || n == 1) {
        return 0;
      }

      int result = 0;
      boolean[] check = new boolean[n + 1];
      for (int i = 1; i < check.length; i++) {
        if (i > 1) {
          if (!check[i]) {
            result++;
            for (int j = i; j < check.length; j += i) {
              check[j] = true;
            }
          }
        }
      }
      return result;
    }
  }


  public static class CountPrimesSolution implements CountPrimesInterface {

    @Override
    public int countPrimes(int n) {
      boolean[] isPrime = new boolean[n];
      Arrays.fill(isPrime, true);
      for (int i = 2; i * i < n; i++) {
        if (isPrime[i]) {
          for (int j = i * i; j < n; j += i) {
            isPrime[j] = false;
          }
        }
      }
      int count = 0;
      for (int i = 2; i < n; i++) {
        if (isPrime[i]) {
          count++;
        }
      }
      return count;
    }
  }

  public interface CountPrimesInterface {

    int countPrimes(int n);
  }
}
