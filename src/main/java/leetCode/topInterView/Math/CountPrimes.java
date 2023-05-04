package leetCode.topInterView.Math;

import java.util.Arrays;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Math
 * @url : https://leetcode.com/explore/featured/card/top-interview-questions-easy/102/math/744/
 * @since : 2023/05/02
 */
public class CountPrimes {

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

  public static class CountPrimesPlayGround implements CountPrimesInterface {

    @Override
    public int countPrimes(int n) {
      return 0;
    }
  }

  public interface CountPrimesInterface {

    int countPrimes(int n);
  }

}
