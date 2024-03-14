package baekjoon.page5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.page5
 * @since : 14.03.24
 */
public class Question14888 {

  public static void main(String[] args) throws IOException {
    Solution solution = new SolutionImplV1();
    solution.doMain();
  }

  static class SolutionImplV1 implements Solution {
    List<Integer> exps = new ArrayList<>();
    List<String> nums = new ArrayList<>();
    List<String> expGroups = new ArrayList<>();
    List<String> results = new ArrayList<>();
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    @Override
    public void doMain() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) { nums.add(st.nextToken()); }
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < 4; i++) { exps.add(Integer.parseInt(st.nextToken())); }
      for (int i = 0; i < exps.get(0); i++) { expGroups.add("+"); }
      for (int i = 0; i < exps.get(1); i++) { expGroups.add("-"); }
      for (int i = 0; i < exps.get(2); i++) { expGroups.add("*"); }
      for (int i = 0; i < exps.get(3); i++) { expGroups.add("/"); }

      for (int i = 0; i < nums.size(); i++) {
        results.add(nums.get(i));
        if(i < nums.size()-1){
          results.add(expGroups.get(i));
        }
      }
      permuteRec(0, expGroups.size(),expGroups.size(), expGroups);
      System.out.println("max = " + max);
      System.out.println("min = " + min);
    }

    public void permuteRec(int depth, int n, int r, List<String> examGroups) {
      if (r == depth) {
        List<String> resExamGroups = new ArrayList<>();
        Queue<String> fianlRes = new LinkedList<>();
        for (int i = 0; i < r; i++) {
          resExamGroups.add(examGroups.get(i));
        }
        for (int i = 0; i < nums.size(); i++) {
          fianlRes.offer(nums.get(i));
          if (i < nums.size() - 1){
            fianlRes.offer(expGroups.get(i));
          }
        }
        int res = calculateResult(fianlRes);
        if(res < min ){ min = res; }
        if(res > max){ max = res; }
      }

      for (int i = depth; i < n; i++) {
        swap(i, depth, examGroups);
        permuteRec(depth + 1, n, r, examGroups);
        swap(i, depth, examGroups);
      }
    }

    private void swap(int i, int j, List<String> nums) {
      String tmp;
      tmp = nums.get(i);
      nums.set(i, nums.get(j));
      nums.set(j, tmp);
    }

    private int calculateResult(Queue<String> fianlRes) {
      Stack<String> stack = new Stack<>();
      int res = 0;
      while (!fianlRes.isEmpty()){
        String poll = fianlRes.poll();
        stack.push(poll);
        if(stack.size() == 3 ){
          Integer back = Integer.valueOf(stack.pop());
          String exp = stack.pop();
          Integer front = Integer.valueOf(stack.pop());
          res = calculate(front, exp, back);
          stack.push(String.valueOf(res));
        }
      }
      return res;
    }

    private int calculate(Integer front, String exp, Integer back) {
      switch (exp) {
        case "+": return front + back;
        case "-": return front - back;
        case "*": return front * back;
        case "/": {
          if(front < 0 && back > 0){ return (((front * -1) / back) * -1);
          } else { return front / back; }
        }
      }
      return 0;
    }
  }

  interface Solution {
    void doMain() throws IOException;
  }
}
