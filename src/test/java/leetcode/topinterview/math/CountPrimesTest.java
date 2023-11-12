package leetcode.topinterview.math;

import leetcode.topinterview.math.CountPrimes.CountPrimesInterface;
import leetcode.topinterview.math.CountPrimes.CountPrimesSolution2;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Math
 * @since : 2023/05/02
 */
public class CountPrimesTest {

  private CountPrimesInterface getSolution() {
    return new CountPrimesSolution2();
  }

  @Test
  public void test_when_n_equals_30() {
    CountPrimesInterface solution = getSolution();
    int result = solution.countPrimes(30);
    Assert.assertEquals(10, result);
  }

  @Test
  public void test_when_n_equals_10() {
    CountPrimesInterface solution = getSolution();
    int result = solution.countPrimes(10);
    Assert.assertEquals(4, result);
  }

  @Test
  public void test_when_n_equals_2() {
    CountPrimesInterface solution = getSolution();
    int result = solution.countPrimes(2);
    Assert.assertEquals(0, result);
  }

  @Test
  public void test_when_n_equals_3() {
    CountPrimesInterface solution = getSolution();
    int result = solution.countPrimes(3);
    Assert.assertEquals(1, result);
  }

}