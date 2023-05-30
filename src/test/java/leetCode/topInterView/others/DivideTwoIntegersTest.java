package leetCode.topInterView.others;

import static org.junit.Assert.*;

import leetCode.topInterView.others.DivideTwoIntegers.DivideTwoIntegersInterface;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.others
 * @since : 2023/05/30
 */
public class DivideTwoIntegersTest {

  @Test
  public void test_divide() {
    DivideTwoIntegersInterface solution = DivideTwoIntegers.getSolution();
    int actual = solution.divide(10, 3);
    assertEquals(3, actual);
  }
}