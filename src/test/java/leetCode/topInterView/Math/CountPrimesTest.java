package leetCode.topInterView.Math;

import leetCode.topInterView.Math.CountPrimes.CountPrimesInterface;
import leetCode.topInterView.Math.CountPrimes.CountPrimesSolution;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Math
 * @since : 2023/05/02
 */
public class CountPrimesTest {

  private CountPrimesInterface getSolution() {
    return new CountPrimesSolution();
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

}