package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutation {

  private List<Integer> permutations = new ArrayList<Integer>();
  private int permutationCount = 0;


  public void calculatePermutataion(){
    init();
    makePermutation(3,3,0);
    System.out.println("##########################");
    System.out.println(permutationCount);
  }

  public void init() {
    permutations.add(1);
    permutations.add(2);
    permutations.add(3);
  }

  public void makePermutation(int n, int r, int depth) {
    System.out.println(n + " : " + r + " : " + depth);

    if (r == depth) {
      printPermutations();
      return;
    }

    for (int i = depth; i < n; i++) {
      Collections.swap(permutations, i, depth);
      makePermutation(n, r, depth + 1);
      Collections.swap(permutations, i, depth);
    }
  }

  private void printPermutations() {
    for (Integer permutation : permutations) {
//      System.out.print(permutation + " ");
    }
    permutationCount ++;
    System.out.println("---------------------");
  }
}
