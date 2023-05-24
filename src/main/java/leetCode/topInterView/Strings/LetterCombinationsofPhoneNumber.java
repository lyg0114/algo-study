package leetCode.topInterView.Strings;

import java.util.List;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Strings
 * @since : 2023/05/25
 */
public class LetterCombinationsofPhoneNumber {

  public static void main(String[] args) {
    LetterCombinationsofPhoneNumberInterface solution = getSolution();
  }

  private static LetterCombinationsofPhoneNumberInterface getSolution() {
    return new LetterCombinationsofPhoneNumberSolutionV1();
  }

  public static class LetterCombinationsofPhoneNumberSolutionV1 implements
      LetterCombinationsofPhoneNumberInterface {

    @Override
    public List<String> letterCombinations(String digits) {
      return null;
    }
  }

  interface LetterCombinationsofPhoneNumberInterface {

    List<String> letterCombinations(String digits);
  }
}
