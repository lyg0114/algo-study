package leetCode.topInterView.easy.Strings;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.easy.Strings
 * @url : https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/887/
 * @since : 2023/03/31
 */
public class LongestCommonPrefix {

  public static void main(String[] args) {
    String[] strs = {"12asf34", "asf1234", "asf1", "asf12", "asf123"};
    LongestCommonPrefixSolution solution = new LongestCommonPrefixSolution();
    solution.longestCommonPrefix(strs);
  }

}

class LongestCommonPrefixSolution {

  public String longestCommonPrefix(String[] strs) {
    List<String> collect = Arrays.stream(strs)
        .sorted((s1, s2) -> s1.length() - s2.length())
        .collect(Collectors.toList());

    String target = collect.get(0);
    for (int i = 1; i < collect.size(); i++) {
      getCommonTarget(target,collect.get(i));
    }

    return target;
  }

  private void getCommonTarget(String target, String s) {

  }
}

