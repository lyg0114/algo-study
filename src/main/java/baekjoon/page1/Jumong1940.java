package baekjoon.page1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.page1
 * @since : 2022/11/24
 */
public class Jumong1940 {
  Stack<Integer> combinations = new Stack<Integer>();
  List<Integer> results = new ArrayList<Integer>();
  int totalCount;
  int choise = 2;
  int resultCnt = 0;
  int result = 0;

  public static void main(String[] args) {
    Jumong1940 jumong1940 = new Jumong1940();
    jumong1940.init();
    jumong1940.makeCombiNation(0);
    jumong1940.print();
  }

  private void init() {
    Scanner scan = new Scanner(System.in);
    totalCount = Integer.parseInt(scan.next());
    resultCnt = Integer.parseInt(scan.next());
    for (int i = 0; i < totalCount; i++) {
      results.add(Integer.parseInt(scan.next()));
    }
  }

  public void makeCombiNation(int start) {
    if (combinations.size() == choise) {
      calculate();
      return;
    }
    for (int i = start; i < totalCount; i++) {
      combinations.push(i);
      makeCombiNation(i + 1);
      combinations.pop();
    }
  }

  public void calculate() {
    int sum = 0;
    for (int i = 0; i < combinations.size(); i++) {
      sum += results.get(combinations.get(i));
    }
    if (sum == resultCnt) {
      result++;
    }
  }

  public void print(){
    System.out.println(result);
  }
}
