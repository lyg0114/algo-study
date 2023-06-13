package leetCode.topInterView.Array;

import java.util.List;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Array
 * @url : https://leetcode.com/problems/group-anagrams/?envType=featured-list&envId=top-interview-questions
 * @since : 2023/06/13
 */
public class GroupAnagrams {

  public static void main(String[] args) {

    GroupAnagramsInterface solution = getSolution();
  }

  public static GroupAnagramsInterface getSolution() {
    return new GroupAnagramsSolutionV1();
  }

  public static class GroupAnagramsSolutionV1 implements GroupAnagramsInterface {

    @Override
    public List<List<String>> groupAnagrams(String[] strs) {
      return null;
    }
  }

  public interface GroupAnagramsInterface {

    List<List<String>> groupAnagrams(String[] strs);
  }

}
