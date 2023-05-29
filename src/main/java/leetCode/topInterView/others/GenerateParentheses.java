package leetCode.topInterView.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.others
 * @url : https://leetcode.com/problems/generate-parentheses/
 * @since : 2023/05/29
 */
public class GenerateParentheses {

  public static void main(String[] args) {
    GenerateParenthesesInterface solution = getSolution();
    List<String> strings = solution.generateParenthesis(3);
    for (String string : strings) {
      System.out.println("string = " + string);
    }
  }

  public static GenerateParenthesesInterface getSolution() {
    return new GenerateParenthesesSolutionV2();
  }

  public static class GenerateParenthesesSolutionV2 implements GenerateParenthesesInterface {

    @Override
    public List<String> generateParenthesis(int n) {
      List<String> result = new ArrayList<>();
      backtrack(result, "", 0, 0, n);
      return result;
    }

    private void backtrack(List<String> result, String current, int open, int close, int max) {
      if (current.length() == max * 2) {
        result.add(current);
        return;
      }

      if (open < max) {
        backtrack(result, current + "(", open + 1, close, max);
      }
      if (close < open) {
        backtrack(result, current + ")", open, close + 1, max);
      }
    }
  }

  public static class GenerateParenthesesSolutionV1 implements GenerateParenthesesInterface {

    @Override
    public List<String> generateParenthesis(int n) {
      if (n < 1 || n > 8) {
        return new ArrayList<>();
      }

      char arr[] = new char[n * 2];
      Set<String> set = new HashSet<String>();
      int i = 0;
      ArrayList<String> results = new ArrayList<>();
      Stack<Character> stack = new Stack<>();

      fillwithChar(n, arr, i);
      generatePermutations(arr, set);
      getResults(set, results, stack);
      return results;
    }

    private void fillwithChar(int n, char[] arr, int i) {
      while (i < 2 * n) {
        if (i < n) {
          arr[i++] = '(';
        } else {
          arr[i++] = ')';
        }
      }
    }

    private void getResults(Set<String> set, ArrayList<String> results,
        Stack<Character> stack) {
      for (String str : set) {
        str = str.replace("[", "")
            .replace("]", "")
            .replace(",", "")
            .replace(" ", "")
        ;
        for (int i = 0; i < str.toCharArray().length; i++) {
          if (stack.size() > 0) {
            Character peek = stack.peek();
            if (compare(peek, str.charAt(i))) {
              stack.pop();
            } else {
              stack.push(str.charAt(i));
            }
          } else {
            stack.push(str.charAt(i));
          }
        }

        if (stack.isEmpty()) {
          results.add(str);
        } else {
          stack.clear();
        }
      }
    }

    private boolean compare(char peek, char s) {
      StringBuffer sb = new StringBuffer();
      sb.append(peek);
      sb.append(s);
      String target = sb.toString();
      if (target.equals("()")) {
        return true;
      } else {
        return false;
      }
    }

    public void generatePermutations(char[] array, Set<String> set) {
      int length = array.length;
      boolean[] used = new boolean[length];
      char[] permutation = new char[length];
      permute(array, permutation, used, 0, set);
    }

    public void permute(char[] array, char[] permutation, boolean[] used, int depth,
        Set<String> set) {
      if (depth == array.length) {
        String result = Arrays.toString(permutation);
        set.add(result);
        return;
      }

      for (int i = 0; i < array.length; i++) {
        if (!used[i]) {
          used[i] = true;
          permutation[depth] = array[i];
          permute(array, permutation, used, depth + 1, set);
          used[i] = false;
        }
      }
    }
  }

  public interface GenerateParenthesesInterface {

    List<String> generateParenthesis(int n);
  }
}

