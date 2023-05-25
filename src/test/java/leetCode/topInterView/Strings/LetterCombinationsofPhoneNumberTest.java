package leetCode.topInterView.Strings;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import leetCode.topInterView.Strings.LetterCombinationsofPhoneNumber.LetterCombinationsofPhoneNumberInterface;
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
}