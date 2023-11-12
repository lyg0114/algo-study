package leetcode.topinterview.array;

import java.util.List;
import leetcode.topinterview.array.GroupAnagrams.GroupAnagramsInterface;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Array
 * @since : 2023/06/13
 */
public class GroupAnagramsTest {

  @Test
  public void test_groupAnagrams_1() {
    GroupAnagramsInterface solution = GroupAnagrams.getSolution();
    String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    List<List<String>> lists = solution.groupAnagrams(strs);
    for (List<String> list : lists) {
      System.out.println("list = " + list);
    }
  }

  @Test
  public void test_groupAnagrams_2() {
    GroupAnagramsInterface solution = GroupAnagrams.getSolution();
    String[] strs = {""};
    List<List<String>> lists = solution.groupAnagrams(strs);
    for (List<String> list : lists) {
      System.out.println("list = " + list);
    }
  }

  @Test
  public void test_groupAnagrams_3() {
    GroupAnagramsInterface solution = GroupAnagrams.getSolution();
    String[] strs = {"a"};
    List<List<String>> lists = solution.groupAnagrams(strs);
    for (List<String> list : lists) {
      System.out.println("list = " + list);
    }
  }
}