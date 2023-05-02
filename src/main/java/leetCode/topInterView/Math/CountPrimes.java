package leetCode.topInterView.Math;

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
      int countOfPrimes = 0;

      for (int i = 1; i <= n; i++) {
        if (isPrime(i)) {
          countOfPrimes++;
        }
      }

      return countOfPrimes;
    }

    private boolean isPrime(int number) {
      boolean isPrime = true;
      if (number == 1) {
        isPrime = false;
      } else {
        for (int i = 2; i <= Math.sqrt(number); i++) {
          if (number % i == 0) {
            isPrime = false;
            break;
          }
        }
      }

      return isPrime;
    }
  }

  public interface CountPrimesInterface {

    int countPrimes(int n);
  }

}
