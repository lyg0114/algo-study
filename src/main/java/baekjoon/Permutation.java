package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Permutation {

  private List<Integer> permutations = new ArrayList<Integer>();
  private int permutationCount = 0;

  public static void main(String[] args) {
    Permutation permutation = new Permutation();
    permutation.calculatePermutataion();
  }

  public void calculatePermutataion() {
    makeTargetLists();
    makePermutation(permutations.size(), permutations.size(), 0);
    System.out.println("##########################");
    System.out.println(permutationCount);
  }

  public void makeTargetLists() {
    int arr[] = {1, 2, 3 , 4};
    permutations = Arrays.stream(arr).boxed().collect(Collectors.toList());
  }

  public void makePermutation(int n, int r, int depth) {
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
      System.out.print(permutation + " ");
    }
    permutationCount++;
    System.out.println("");
    System.out.println("---------------------");
  }
}
