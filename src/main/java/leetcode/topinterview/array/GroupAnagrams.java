package leetcode.topinterview.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Array
 * @url : https://leetcode.com/problems/group-anagrams/?envType=featured-list&envId=top-interview-questions
 * @since : 2023/06/13
 */
public class GroupAnagrams {

  public static void main(String[] args) {
    String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    GroupAnagramsInterface solution = getSolution();
    List<List<String>> lists = solution.groupAnagrams(strs);
    for (List<String> list : lists) {
      System.out.println("list = " + list);
    }
  }

  public static GroupAnagramsInterface getSolution() {
    return new GroupAnagramsSolutionV1();
  }

  public static class GroupAnagramsSolutionV2 implements GroupAnagramsInterface {

    @Override
    public List<List<String>> groupAnagrams(String[] strs) {
      Map<String, List<String>> map = new HashMap<>();

      for (String str : strs) {
        String sortedStr = sortString(str);
        List<String> anagramList = map.getOrDefault(sortedStr, new ArrayList<>());
        anagramList.add(str);
        map.put(sortedStr, anagramList);
      }
      return new ArrayList<>(map.values());
    }

    private String sortString(String str) {
      char[] chArr = str.toCharArray();
      Arrays.sort(chArr);
      return new String(chArr);
    }
  }

  public static class GroupAnagramsSolutionV1 implements GroupAnagramsInterface {

    @Override
    public List<List<String>> groupAnagrams(String[] strs) {
      List<String> lis = new LinkedList<>();
      for (String str : strs) {
        lis.add(str);
      }

      List<List<String>> res = new ArrayList<>();
      for (String li : lis) {
        char[] chs = li.toCharArray();
        ArrayList<String> collect = new ArrayList<>();
        permuteRec(0, chs.length, chs.length, chs, lis, collect);
        res.add(collect);
      }

      return res;
    }

    public void permuteRec(int depth, int n, int r, char[] chs, List<String> links,
        List<String> res) {
      if (r == depth) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < r; i++) {
          sb.append(chs[i]);
        }
        String val = sb.toString();
        System.out.println("val = " + val);
        if (links.remove(val)) {
          res.add(val);
        }
      }

      for (int i = depth; i < n; i++) {
        swap(i, depth, chs);
        permuteRec(depth + 1, n, r, chs, links, res);
        swap(i, depth, chs);
      }
    }

    private void swap(int i, int j, char[] ch) {
      char tmp;
      tmp = ch[i];
      ch[i] = ch[j];
      ch[j] = tmp;
    }
  }

  public interface GroupAnagramsInterface {

    List<List<String>> groupAnagrams(String[] strs);
  }

}
