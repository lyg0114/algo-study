package pramp;

import java.util.Arrays;

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
      return null;
    }
  }

  interface WordCountEngineInterface {

    String[][] wordCountEngine(String document);
  }
}
