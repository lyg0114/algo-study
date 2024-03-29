package leetcode.topinterview.strings;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import leetcode.topinterview.strings.LetterCombinationsofPhoneNumber.LetterCombinationsofPhoneNumberInterface;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Strings
 * @since : 2023/05/25
 */
public class LetterCombinationsofPhoneNumberTest {

  @Test
  public void test_letterCombinations_1() {
    LetterCombinationsofPhoneNumberInterface solution = LetterCombinationsofPhoneNumber
        .getSolution();
    List<String> results = solution.letterCombinations("23");
    assertEquals(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"),
        results);
  }

  @Test
  public void test_letterCombinations_2() {
    LetterCombinationsofPhoneNumberInterface solution = LetterCombinationsofPhoneNumber
        .getSolution();
    List<String> results = solution.letterCombinations("234");
    System.out.println("results = " + results);
  }

}