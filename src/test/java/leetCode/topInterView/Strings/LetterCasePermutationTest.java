package leetCode.topInterView.Strings;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import leetCode.topInterView.Strings.LetterCasePermutation.LetterCasePermutationInteface;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Strings
 * @since : 2023/06/04
 */
public class LetterCasePermutationTest {

  @Test
  public void test_letterCasePermutation_1() {
    LetterCasePermutationInteface solution = LetterCasePermutation.getSolution();
    String in = "a1b2";
    List<String> actuals = solution.letterCasePermutation(in);
    List<String> expects = Arrays.asList("a1b2", "a1B2", "A1b2", "A1B2");
    assertEquals(expects, actuals);
  }

  @Test
  public void test_letterCasePermutation_2() {
    LetterCasePermutationInteface solution = LetterCasePermutation.getSolution();
    String in = "C";
    List<String> actuals = solution.letterCasePermutation(in);
    List<String> expects = Arrays.asList("C", "c");
    assertEquals(expects, actuals);
  }

  @Test
  public void test_letterCasePermutation_3() {
    LetterCasePermutationInteface solution = LetterCasePermutation.getSolution();
    String in = "c";
    List<String> actuals = solution.letterCasePermutation(in);
    List<String> expects = Arrays.asList("C", "c");
    assertEquals(expects, actuals);
  }

  @Test
  public void test_letterCasePermutation_4() {
    LetterCasePermutationInteface solution = LetterCasePermutation.getSolution();
    String in = "po";
    List<String> actuals = solution.letterCasePermutation(in);
    List<String> expects = Arrays.asList("po", "pO", "Po", "PO");
    assertEquals(expects, actuals);
  }
}