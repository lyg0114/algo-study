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
    return new WordCountEngineSolutionV1();
  }

  public static class WordCountEngineSolutionV2 implements WordCountEngineInterface {

    private final String SPACE = " ";

    @Override
    public String[][] wordCountEngine(String document) {
      return null;
    }

    public void extractWordFromDocument(int maxCnt, String document, List strings,
        Map<String, Integer> cntMap) {
      String[] split = document.split(SPACE);
      for (String token : split) {
        String word = getWordFromToken(token);
        if (!strings.contains(word)) {
          strings.add(word);
        }
        int cnt = cntMap.getOrDefault(word, 0) + 1;
        maxCnt = Math.max(maxCnt, cnt);
        cntMap.put(word, cnt);
      }
    }

    public String getWordFromToken(String token) {
      StringBuilder word = new StringBuilder();
      for (char c : token.toCharArray()) {
        if (Character.isLetter(c)) {
          word.append(Character.toLowerCase(c));
        }
      }
      return word.toString();
    }

  }

  public static class WordCountEngineSolutionV1 implements WordCountEngineInterface {

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

    private String getWordFromToken(String token) {
      StringBuilder word = new StringBuilder();
      for (char c : token.toCharArray()) {
        if (Character.isLetter(c)) {
          word.append(Character.toLowerCase(c));
        }
      }
      return word.toString();
    }
  }

  interface WordCountEngineInterface {

    String[][] wordCountEngine(String document);
  }
}
