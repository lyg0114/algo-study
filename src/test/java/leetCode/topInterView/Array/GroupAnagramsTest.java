package leetCode.topInterView.Array;

import static org.junit.Assert.*;

import java.util.List;
import leetCode.topInterView.Array.GroupAnagrams.GroupAnagramsInterface;
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
}