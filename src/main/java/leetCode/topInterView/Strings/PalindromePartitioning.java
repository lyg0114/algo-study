package leetCode.topInterView.Strings;

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
      return null;
    }
  }

  public interface PalindromePartitioningInterface {

    List<List<String>> partition(String s);
  }
}
