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
      split[i] = split[i].replaceAll("[^a-z]", "");
    }
    Map<String, Long> collect = Arrays.stream(split)
        .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
    HashMap<Long, ArrayList<String>> results = new HashMap<>();
    long maxCnt = 0;
    for (String s : split) {
      Long key = collect.get(s);
      maxCnt = key > maxCnt ? key : maxCnt;
      List<String> strings = results.get(key);
      if (strings == null || strings.isEmpty()) {
        ArrayList<String> objects = new ArrayList<>();
        objects.add(s);
        results.put(key, objects);
      } else {
        List<String> strs = results.get(key);
        if(!strs.contains(s)){
          strs.add(s);
        }
      }
    }

    System.out.println("results = " + results);
    return null;
  }
}
