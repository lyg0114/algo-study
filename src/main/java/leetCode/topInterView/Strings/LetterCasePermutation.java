package leetCode.topInterView.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    System.out.println(strings);
  }

  public static LetterCasePermutationInteface getSolution() {
    return new LetterCasePermutationSolutionV2();
  }

  public static class LetterCasePermutationSolutionV2 implements LetterCasePermutationInteface {

    @Override
    public List<String> letterCasePermutation(String s) {
      List<String> result = new ArrayList<>();
      backtrack(s.toCharArray(), 0, result);
      return result;
    }

    private static void backtrack(char[] chars, int index, List<String> result) {
      if (index == chars.length) {
        result.add(new String(chars));
        return;
      }

      if (Character.isLetter(chars[index])) {
        chars[index] = Character.toLowerCase(chars[index]);
        backtrack(chars, index + 1, result);
        chars[index] = Character.toUpperCase(chars[index]);
      }
      backtrack(chars, index + 1, result);
    }

  }

  public static class LetterCasePermutationSolutionV1 implements LetterCasePermutationInteface {

    private Set<String> set = new HashSet<>();

    @Override
    public List<String> letterCasePermutation(String s) {
      if (s.length() == 1) {
        if (Character.isAlphabetic(s.charAt(0))) {
          if (Character.isLowerCase(s.charAt(0))) {
            return Arrays.asList(s, String.valueOf((char) ((s.charAt(0)) - 32)));
          } else {
            return Arrays.asList(s, String.valueOf((char) ((s.charAt(0)) + 32)));
          }
        } else {
          return Arrays.asList(s);
        }
      }
      letterCase(s.toCharArray(), s.length(), s.length(), 0);
      return new ArrayList<>(set);
    }

    private void letterCase(char[] chars, int n, int r, int depth) {
      set.add(new String(chars));
      if (r == depth) {
        return;
      }
      for (int i = depth; i < n; i++) {
        char c = chars[i];
        if (Character.isAlphabetic(c)) {
          chageUpperLower(chars, i);
          letterCase(chars, n, r, depth + 1);
          chageUpperLower(chars, i);
        }
      }
    }

    private void printChars(char[] chars, int n) {
      ArrayList<Character> res = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        res.add(chars[i]);
      }
      System.out.println("res = " + res);
    }

    private void chageUpperLower(char[] chars, int i) {
      if (Character.isLowerCase(chars[i])) {
        chars[i] = (char) (chars[i] - 32);
      } else {
        chars[i] = (char) (chars[i] + 32);
      }
    }
  }

  interface LetterCasePermutationInteface {

    List<String> letterCasePermutation(String s);
  }
}
