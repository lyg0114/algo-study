package pramp;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import pramp.WordCountEngine.WordCountEngineInterface;
import pramp.WordCountEngine.WordCountEngineSolutionV2;

/**
 * @author : iyeong-gyo
 * @package : pramp
 * @since : 2023/05/26
 */
public class WordCountEngineTest {

  @Test
  public void wordCountEngine_test_1() {
    WordCountEngineInterface solution = WordCountEngine.getSolution();
    String document = "practice makes perfect youll only get perfect by practice just practice";
    String[][] strings = solution.wordCountEngine(document);
    for (String[] string : strings) {
      for (String s : string) {
        System.out.print(s + " ");
      }
      System.out.println();
    }
  }

  @Test
  public void test_extractWordFromDocument() {
    WordCountEngineSolutionV2 solution = new WordCountEngineSolutionV2();
    String document = "To be, or not to be, that is the question:";
    List strings = new ArrayList();
    Map strCntMap = new HashMap<String, Integer>();
    int maxCnt = 0;

    solution.extractWordFromDocument(maxCnt, document, strings, strCntMap);

    String[] asserts = {"to", "be", "or", "not", "that", "is", "the", "question"};
    for (int i = 0; i < strings.size(); i++) {
      assertEquals(strings.get(i), asserts[i]);
    }

    Map<String, Integer> assetCntMap = new HashMap<String, Integer>() {{
      put("to", 2);
      put("be", 2);
      put("or", 1);
      put("not", 1);
      put("that", 1);
      put("is", 1);
      put("the", 1);
      put("question", 1);
    }};
    for (String s : assetCntMap.keySet()) {
      assertEquals(strCntMap.get(s), assetCntMap.get(s));
    }
  }
}