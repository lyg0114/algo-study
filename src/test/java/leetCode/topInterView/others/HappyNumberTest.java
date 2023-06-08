package leetCode.topInterView.others;

import static org.junit.Assert.*;

import leetCode.topInterView.others.HappyNumber.HappyNumberInterface;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.others
 * @since : 2023/06/08
 */
public class HappyNumberTest {

  @Test
  public void test_isHappy_1() {
    HappyNumberInterface solution = HappyNumber.getSolution();
    int n = 19;
    boolean actual = solution.isHappy(n);
    assertTrue(actual);
  }

  @Test
  public void test_isHappy_2() {
    HappyNumberInterface solution = HappyNumber.getSolution();
    int n = 2;
    boolean actual = solution.isHappy(n);
    assertFalse(actual);
  }

  @Test
  public void test_isHappy_3() {
    HappyNumberInterface solution = HappyNumber.getSolution();
    int n = Integer.MAX_VALUE - 1;
    boolean actual = solution.isHappy(n);
    assertFalse(actual);
  }

  @Test
  public void test_isHappy_4() {
    HappyNumberInterface solution = HappyNumber.getSolution();
    int n = 1;
    boolean actual = solution.isHappy(n);
    assertTrue(actual);
  }
}