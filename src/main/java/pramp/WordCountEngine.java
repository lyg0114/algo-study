package pramp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
