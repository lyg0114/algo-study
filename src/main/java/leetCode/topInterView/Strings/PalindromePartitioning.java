package leetCode.topInterView.Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Strings
 * @url : https://leetcode.com/problems/palindrome-partitioning/?envType=featured-list&envId=top-interview-questions
 * @since : 2023/06/17
 */
public class PalindromePartitioning {

  public static void main(String[] args) {
    PalindromePartitioningInterface solution = getSolution();
    String s = "aab";
    List<List<String>> partition = solution.partition(s);
    for (List<String> strings : partition) {
      System.out.println("strings = " + strings);
    }
  }

  public static PalindromePartitioningInterface getSolution() {
    return new PalindromePartitioningSolutionV1();
  }

  public static class PalindromePartitioningSolutionV1 implements PalindromePartitioningInterface {

    @Override
    public List<List<String>> partition(String s) {
      List<List<String>> result = new ArrayList<>();
      backtrack(s, 0, new ArrayList<>(), result);
      return result;
    }

    private void backtrack(String s, int start, List<String> path, List<List<String>> result) {
      if (start == s.length()) {
        result.add(new ArrayList<>(path));
        return;
      }

      for (int end = start + 1; end <= s.length(); end++) {
        String sub = s.substring(start, end);
        if (isPalindrome(sub)) {
          path.add(sub);
          backtrack(s, end, path, result);
          path.remove(path.size() - 1);
        }
      }
    }

    private boolean isPalindrome(String s) {
      int left = 0;
      int right = s.length() - 1;
      while (left < right) {
        if (s.charAt(left) != s.charAt(right)) {
          return false;
        }
        left++;
        right--;
      }
      return true;
    }
  }

  public interface PalindromePartitioningInterface {

    List<List<String>> partition(String s);
  }
}
