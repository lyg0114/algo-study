package pramp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : iyeong-gyo
 * @package : pramp
 * @since : 2023/05/25
 */
public class WordCountEngine {

  public static void main(String[] args) {
    WordCountEngineInterface solution = getSolution();
    String document = "Practice makes perfect. you'll only get Perfect by practice. just practice!";
    String[][] strings = solution.wordCountEngine(document);
    for (String[] string : strings) {
      System.out.println("string = " + Arrays.toString(string));
    }
  }

  public static WordCountEngineInterface getSolution() {
    return new WordCountEngineSolutionV3();
  }

  public static class WordCountEngineSolutionV3 implements WordCountEngineInterface {

    @Override
    public String[][] wordCountEngine(String document) {
      final String SPACE = " ";
      String[] tokenized = document.split(SPACE);
      Map<String, Integer> wordCounts = new HashMap<>();
      List<String> uniqueWords = new ArrayList<>();

      int maxCount = 0;
      for (String token : tokenized) {
        String word = getWordFromToken(token);
        if (word.length() == 0) {
          continue;
        }
        int count = wordCounts.getOrDefault(word, 0) + 1;
        wordCounts.put(word, count);
        maxCount = Math.max(maxCount, count);
        if (!uniqueWords.contains(word)) {
          uniqueWords.add(word);
        }
      }

      List<List<String>> buckets = new ArrayList<>();
      for (int i = 0; i <= maxCount; i++) {
        buckets.add(new ArrayList<>());
      }

      for (String word : uniqueWords) {
        int count = wordCounts.get(word);
        buckets.get(count).add(word);
      }

      String[][] result = new String[uniqueWords.size()][2];
      int index = 0;
      for (int i = maxCount; i >= 0; i--) {
        List<String> bucket = buckets.get(i);
        for (String word : bucket) {
          result[index][0] = word;
          result[index][1] = String.valueOf(i);
          index++;
        }
      }

      return result;
    }

    private static String getWordFromToken(String token) {
      StringBuilder word = new StringBuilder();
      for (char c : token.toCharArray()) {
        if (Character.isLetter(c)) {
          word.append(Character.toLowerCase(c));
        }
      }
      return word.toString();
    }


  }

  public static class WordCountEngineSolutionV2 implements WordCountEngineInterface {

    public static String getWordFromToken(String input) {
      final StringBuilder builder = new StringBuilder();
      for (final char c : input.toCharArray()) {
        if (Character.isLetterOrDigit(c)) {
          builder.append(Character.isLowerCase(c) ? c : Character.toLowerCase(c));
        }
      }
      return builder.toString();
    }

    @Override
    public String[][] wordCountEngine(String document) {
      final String SPACE = " ";
      String[] tokenized = document.split(SPACE);
      Map<String, Integer> hm = new HashMap<>();
      List<String> listStr = new ArrayList<>();
      int maxCounter = 0;
      for (String token : tokenized) {
        String word = getWordFromToken(token);
        if (word.length() == 0) {
          continue;
        }
        if (!hm.containsKey(word)) {
          listStr.add(word);
          hm.put(word, 1);
        } else {
          hm.put(word, hm.get(word) + 1);
        }
        maxCounter = hm.get(word) > maxCounter ? hm.get(word) : maxCounter;
      }

      List<List<String>> list = new ArrayList<>();
      for (int i = 0; i < maxCounter + 1; i++) {
        list.add(new ArrayList<String>());
      }

      for (String word : listStr) {
        list.get(hm.get(word)).add(word);
      }

      String[][] res = new String[listStr.size()][2];
      int counter = 0;
      for (int i = list.size() - 1; i >= 0; i--) {
        if (list.get(i).size() != 0) {
          for (String word : list.get(i)) {
            res[counter][0] = word;
            res[counter][1] = String.valueOf(i);
            counter++;
          }
        }
      }
      return res;
    }

  }

  public static class WordCountEngineSolutionV1 implements WordCountEngineInterface {

    @Override
    public String[][] wordCountEngine(String document) {
      String[] s = document.split(" ");
      List<Doc> docs = new ArrayList<>();
      HashMap<String, Integer> cntMap = new HashMap<>();
      for (int i = 0; i < s.length; i++) {
        if (cntMap.containsKey(s[i])) {
          if (cntMap.get(s[i]) > 0) {
            cntMap.replace(s[i], cntMap.get(s[i]) + 1);
          } else {
            cntMap.replace(s[i], 1);
          }
        } else {
          cntMap.put(s[i], 1);
        }
        docs.add(new Doc(s[i], i, 0));
      }

      for (String s1 : cntMap.keySet()) {
        System.out.println("s1 : cntMap.get(s1) = " + s1 + " : " + cntMap.get(s1));
      }
      System.out.println("########################");
      for (Doc doc : docs) {
        doc.setCount(cntMap.get(doc.getStr()));
        System.out.println("doc = " + doc);
      }

      return null;
    }

    public static class Doc {

      private String str;
      private int order;
      private int count;

      public Doc(String str, int order, int count) {
        this.str = str;
        this.order = order;
        this.count = count;
      }

      @Override
      public String toString() {
        return "Doc{" +
            "str='" + str + '\'' +
            ", order=" + order +
            ", count=" + count +
            '}';
      }

      public String getStr() {
        return str;
      }

      public void setStr(String str) {
        this.str = str;
      }

      public int getOrder() {
        return order;
      }

      public void setOrder(int order) {
        this.order = order;
      }

      public int getCount() {
        return count;
      }

      public void setCount(int count) {
        this.count = count;
      }
    }
  }

  interface WordCountEngineInterface {

    String[][] wordCountEngine(String document);
  }
}
