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
  public void test_isHappy() {
    HappyNumberInterface solution = HappyNumber.getSolution();
    int n = 19;
    boolean actual = solution.isHappy(n);
    assertTrue(actual);
  }
}