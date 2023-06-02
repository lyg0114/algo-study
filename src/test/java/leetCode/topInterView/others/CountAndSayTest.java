package leetCode.topInterView.others;

import static org.junit.Assert.*;

import leetCode.topInterView.others.CountAndSay.CountAndSayInterface;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.others
 * @since : 2023/06/02
 */
public class CountAndSayTest {

  @Test
  public void test_countAndSay() {
    CountAndSayInterface solution = CountAndSay.getSolution();
    String actual = solution.countAndSay(4);
    assertEquals("1211", actual);
  }
}