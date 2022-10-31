package baekjoon.page1.countofAlpabet;

import java.util.HashMap;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.page1
 * @since : 2022/10/30
 * 알파벳 소문자로만 이루어진 단어 S가 주어진다.
 * 각 알파벳이 단어에 몇 개가 포함되어 있는지 구하는 프로그램을 작성하시오.
 */
public class CountOfAlpabet {
  HashMap<String, Integer> alpabetCountMap = new HashMap<>();

  public static void main(String[] args) {
    CountOfAlpabet countOfAlpabet = new CountOfAlpabet();
    countOfAlpabet.initAlpabetMap();
    String [] arr = {"y","g","l","e","e"};
    countOfAlpabet.calculate(arr);
    countOfAlpabet.printResult();
  }

  private void printResult() {
    for (String key : alpabetCountMap.keySet()) {
      System.out.println(key + " : " + alpabetCountMap.get(key));
    }
  }

  public void calculate(String [] arr ) {
    for (String str : arr) {
      alpabetCountMap.replace(str, alpabetCountMap.get(str) + 1);
    }
  }

  private void initAlpabetMap() {
    alpabetCountMap.put("a",0);
    alpabetCountMap.put("b",0);
    alpabetCountMap.put("c",0);
    alpabetCountMap.put("d",0);
    alpabetCountMap.put("e",0);
    alpabetCountMap.put("f",0);
    alpabetCountMap.put("g",0);
    alpabetCountMap.put("h",0);
    alpabetCountMap.put("j",0);
    alpabetCountMap.put("k",0);
    alpabetCountMap.put("l",0);
    alpabetCountMap.put("m",0);
    alpabetCountMap.put("n",0);
    alpabetCountMap.put("o",0);
    alpabetCountMap.put("p",0);
    alpabetCountMap.put("q",0);
    alpabetCountMap.put("r",0);
    alpabetCountMap.put("s",0);
    alpabetCountMap.put("t",0);
    alpabetCountMap.put("u",0);
    alpabetCountMap.put("v",0);
    alpabetCountMap.put("w",0);
    alpabetCountMap.put("x",0);
    alpabetCountMap.put("y",0);
    alpabetCountMap.put("z",0);
  }
}
