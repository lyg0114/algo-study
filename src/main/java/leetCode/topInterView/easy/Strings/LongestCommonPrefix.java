package leetCode.topInterView.easy.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.easy.Strings
 * @url : https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/887/
 * @since : 2023/03/31
 */
public class LongestCommonPrefix {
  public static void main(String[] args) {
  }
}

class LongestCommonPrefixSolution {

  public String longestCommonPrefix(String[] strs) {
    List<String> collect = Arrays.stream(strs)
        .sorted((s1, s2) -> s1.length() - s2.length())
        .collect(Collectors.toList());

    String target = collect.get(0);
    for (int i = 1; i < collect.size(); i++) {
      getCommonTarget(target, collect.get(i));
    }

    return target;
  }

  //[x] 1.target의 첫번째 문자열이 str의 모든 문자에 대해 출현하는 시작 포인트를 stack에 저장한다.
  //[]  2.시작 포이트로부터 한칸씩 이동하면서 동일한 문자열인지 검사한다.
  //[]  3.모든 시작 포인트에 대하여 2의 연산을 수행한다.
  private void getCommonTarget(String target, String str) {
    char[] chTargets = target.toCharArray();
    char[] chStrs = str.toCharArray();
    List<Integer> start = new ArrayList<>();
    for (int i = 0; i < chStrs.length; i++) {
      if (chTargets[0] == chStrs[i]) {
        start.add(i);
      }
    }

    for (Integer index : start) {

    }
  }
}

