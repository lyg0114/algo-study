package leetcode.topinterview.strings;

import static org.junit.Assert.*;

import leetcode.topinterview.strings.ReverseStr.ReverseStrInterface;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Strings
 * @since : 2023/06/02
 */
public class ReverseStrTest {

  @Test
  public void test_reverseArr_1() {
    ReverseStrInterface solution = ReverseStr.getSolution();
    String input = "Hello World";
    String actual = solution.reverseArr(input);
    assertEquals("dlroW olleH", actual);
  }

  @Test
  public void test_reverseArr_2() {
    ReverseStrInterface solution = ReverseStr.getSolution();
    String input = "H";
    String actual = solution.reverseArr(input);
    assertEquals("H", actual);
  }

  @Test
  public void test_reverseArr_3() {
    ReverseStrInterface solution = ReverseStr.getSolution();
    String input = "";
    String actual = solution.reverseArr(input);
    assertEquals("", actual);
  }

  @Test
  public void test_reverseArr_4() {
    ReverseStrInterface solution = ReverseStr.getSolution();
    String input = "aaasssdddfff";
    String actual = solution.reverseArr(input);
    assertEquals("fffdddsssaaa", actual);
  }
}