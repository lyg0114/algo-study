package leetCode.topInterView.Strings;

import java.util.List;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Strings
 * @since : 2023/06/03
 */
public class LetterCasePermutation {

  public static void main(String[] args) {
    LetterCasePermutationInteface solution = getSolution();
    String in = "a1b2";
    List<String> strings = solution.letterCasePermutation(in);
    System.out.println("strings = " + strings);
  }

  public static LetterCasePermutationInteface getSolution() {
    return new LetterCasePermutationSolutionV1();
  }

  public static class LetterCasePermutationSolutionV1 implements LetterCasePermutationInteface {

    @Override
    public List<String> letterCasePermutation(String s) {
      letterCase(s.toCharArray(), s.length(), s.length() - 1, 1);
      return null;
    }

    private void letterCase(char[] chars, int n, int r, int depth) {
      if (r == depth) {
        for (int i = 0; i < r; i++) {
          System.out.println("chars = " + chars[i]);
        }
        System.out.println("########################");
        return;
      }

      for (int i = depth; i < n; i++) {
        char c = chars[i];
        if (Character.isAlphabetic(c)) {
          if (Character.isLowerCase(c)) {
            chars[i] = (char) (c - 32);
          } else {
            chars[i] = (char) (c + 32);
          }
          letterCase(chars, n, r, depth + 1);
        }
      }
    }
  }

  interface LetterCasePermutationInteface {

    List<String> letterCasePermutation(String s);
  }
}
