package pramp;

import org.junit.Test;
import pramp.WordCountEngine.WordCountEngineInterface;

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

}