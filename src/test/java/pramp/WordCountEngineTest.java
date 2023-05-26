package pramp;

import static org.junit.Assert.*;

import org.junit.Test;
import pramp.WordCountEngine.WordCountEngineInterface;

/**
 * @author : iyeong-gyo
 * @package : pramp
 * @since : 2023/05/26
 */
public class WordCountEngineTest {
  @Test
  public void wordCountEngine_test_1(){
    WordCountEngineInterface solution = WordCountEngine.getSolution();
    String document = "practice makes perfect youll only get perfect by practice just practice";
    solution.wordCountEngine(document);
  }

}