package leetcode.topinterview.others;

import static org.junit.Assert.*;

import leetcode.topinterview.others.DivideTwoIntegers.DivideTwoIntegersInterface;
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

  @Test
  public void test_bit_oper() {
    int value = 5;
    System.out.println("value = " + value);
    int result = value << 2;
    System.out.println("result = " + result);
  }

}