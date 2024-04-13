package leetcode.topinterview.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author : iyeong-gyo
 * @package : leetcode.topinterview.others
 * @since : 11.04.24
 */
public class WordCountEngine {
  public static void main(String[] args) {
    String[][] strings
        = wordCountEngine(
        "Practice makes perfect. you'll only get Perfect by practice. just practice!"
    );
    for (int i = 0; i < strings.length; i++) {
      for (int j = 0; j < strings[i].length; j++) {
        System.out.println("strings = " + strings[i][j]);
      }
    }
  }

  // sort by count des ordr
  // if count is same, we follows the order of origianl sentence.
  // Upper case and Lower case is same (Perfect == perfect)
  // strip out punctuation , seperate by whitespace
  // ########################################################
  // 1. strip out punctuation [x]
  // 2. seperate sentenct by whitespace [x]
  // 3. iterate sentence and check the count and make the Map<Integer, List<String>>
  public static String[][] wordCountEngine(String document) {
    String[] split = document.toLowerCase().split(" ");
    for (int i = 0; i < split.length; i++) {
      split[i] = split[i].replaceAll("[^a-z]", ""); }
    Map<String, Long> collect = Arrays.stream(split).collect(Collectors.groupingBy(s -> s, Collectors.counting()));
    Map<Long, List<String>> results = new HashMap<>();
    long maxCnt = 0;

    for (String s : split) {
      Long key = collect.get(s);
      maxCnt = key > maxCnt ? key : maxCnt;
      List<String> strings = results.get(key);
      if (strings == null || strings.isEmpty()) {
        List<String> data = new ArrayList<>();
        data.add(s);
        results.put(key, data);
      } else {
        List<String> strs = results.get(key);
        if(!strs.contains(s)){
          strs.add(s);
        }
      }
    }

    String [][] res = new String[collect.size()][2];
    int idx = 0;
    if(idx < collect.size() - 1){
      for (long key = (int) maxCnt; key > 0; key--) {
        List<String> strings = results.get(key);
        for (String str : strings) {
          res[idx][0] = str;
          res[idx][1] = String.valueOf(key);
          idx++;
        }
      }
    }

    return res;
  }
}
