package leetCode.topInterView.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Strings
 * @url : https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/887/
 * @since : 2023/03/31
 */
public class LongestCommonPrefix {

  public static void main(String[] args) {
  }
}

class LongestCommonPrefixSolution {

  public String longestCommonPrefix(String[] strs) {
    try {
      List<String> collect = Arrays.stream(strs)
          .sorted((s1, s2) -> s1.length() - s2.length())
          .collect(Collectors.toList());
      String target = collect.get(0);
      for (int i = 1; i < collect.size(); i++) {
        target = getCommonTarget(target, collect.get(i));
        if (target.equals("")) {
          return target;
        }
      }
      return target;
    } catch (Exception e) {
      return "";
    }
  }

  public String getCommonTarget(String target, String strs) {
    Stack<String> commonTargets = getCommonTargets(target, strs);
    return commonTargets.stream()
        .max((s1, s2) -> s1.length() - s2.length())
        .orElse("")
        ;
  }

  public Stack<String> getCommonTargets(String target, String str) {
    char[] chTargets = target.toCharArray();
    char[] chStrs = str.toCharArray();
    List<Integer> starts = new ArrayList<>();
    for (int i = 0; i < chStrs.length; i++) {
      if (chTargets[0] == chStrs[i]) {
        starts.add(i);
      }
    }

    Stack<String> tmpTargetStack = new Stack<>();
    for (Integer startIndex : starts) {
      int i = 0;
      List<Character> chrs = new ArrayList<>();
      while (true) {
        if (chTargets[i] == chStrs[startIndex + i]) {
          chrs.add(chTargets[i]);
        } else {
          tmpTargetStack.push(converToString(chrs));
          break;
        }
        if (chTargets.length == ++i) {
          tmpTargetStack.push(converToString(chrs));
          break;
        }
      }
    }

    return tmpTargetStack;
  }

  public String converToString(List<Character> chrs) {
    StringBuffer sb = new StringBuffer(chrs.size());
    for (Character chr : chrs) {
      sb.append(chr);
    }
    return sb.toString();
  }
}











