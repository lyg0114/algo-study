package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Combination {

  private List<Integer> results = new ArrayList<Integer>();
  private Stack<Integer> combinations = new Stack<Integer>();
  private int totalCount;
  private int choise;

  private int combinationCount = 0;

  public Combination() {
    init();
  }

  private void init() {
    totalCount = 5;
    choise = 3;
    results.add(1);
    results.add(2);
    results.add(3);
    results.add(4);
    results.add(5);
  }

  public void makeCombiNation(int start) {
    if (combinations.size() == choise) {
      printCombinations(combinations);
      return;
    }

    for (int i = start + 1; i < totalCount; i++) {
      combinations.push(i);
      makeCombiNation(i);
      combinations.pop();
    }
    return;
  }

  public void printCombinations(List<Integer> combinations) {
    for (int i = 0; i < combinations.size(); i++) {
      System.out.print(results.get(combinations.get(i)));
    }
    System.out.println("");
  }

}
