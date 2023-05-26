package pramp;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import pramp.WordCountEngine.WordCountEngineInterface;
import pramp.WordCountEngine.WordCountEngineSolutionV1;
import pramp.WordCountEngine.WordCountEngineSolutionV2;

/**
 * @author : iyeong-gyo
 * @package : pramp
 * @since : 2023/05/26
 */
public class WordCountEngineTest {

  @Test
  public void wordCountEngine_test_1() {
    List<String> docs = Arrays.asList(
        "Practice makes perfect, you'll get perfecT by practice. just practice! just just just!!",
        "To be, or not to be, that is the question:",
        "very book is a quotation; and every house is a quotation out of all forests, and mines, and stone quarries; and every man is a quotation from all his ancestors. ",
        "I have failed over and over and over again in my life and that is why I succeed.",
        "Look If you had One shot, Or one opportunity, To seize everything you ever wanted, In one moment, Would you capture it, Or just let it slip?",
        "Cause I'm Slim Shady, yes I'm the real Shady, All you other Slim Shadys are just imitating So won't the real Slim Shady, please stand up, Please stand up, Please stand up"
    );
    for (String doc : docs) {
      testString(doc);
    }
  }

  private void testString(String document) {
    WordCountEngineInterface solution1 = new WordCountEngineSolutionV1();
    WordCountEngineInterface solution2 = new WordCountEngineSolutionV2();
    String[][] results1 = solution1.wordCountEngine(document);
    String[][] results2 = solution2.wordCountEngine(document);
    assertEquals(results1.length, results2.length);

    for (int i = 0; i < results1.length; i++) {
      for (int j = 0; j < 2; j++) {
        assertEquals(results1[i][j], results2[i][j]);
      }
    }
  }

  @Test
  public void test_extractWordFromDocument() {
    WordCountEngineSolutionV2 solution = new WordCountEngineSolutionV2();
    String document = "To be, or not to be, that is the question:";
    List strings = new ArrayList();
    Map strCntMap = new HashMap<String, Integer>();

    int maxCnt = solution.extractWordFromDocument(document, strings, strCntMap);

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
    assertEquals(2, maxCnt);
  }
}