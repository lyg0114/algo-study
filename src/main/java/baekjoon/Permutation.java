package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
 * calculate nPr
 * */
public class Permutation {

  private List<Integer> permutations = new ArrayList<Integer>();
  private int permutationCount = 0;

  public static void main(String[] args) {
    Permutation permutation = new Permutation();
    permutation.calculatePermutataion();
  }

  public void calculatePermutataion() {
    makeTargetLists();
    makePermutation(permutations.size(), 3, 0);
    System.out.println("##########################");
    System.out.println(permutationCount);
  }

  public void makeTargetLists() {
    int arr[] = {1, 2, 3};
    permutations = Arrays.stream(arr).boxed().collect(Collectors.toList());
  }

  public void makePermutation(int number, int choice, int depth) {
    System.out.println("number = " + number + ", choice : " + choice + ", depth : " + depth);
    if (choice == depth) {
      printPermutations(depth);
      return;
    }
    for (int i = depth; i < number; i++) {
      System.out.println("before [i, depth] : [" + i + "," + depth + "]");
      Collections.swap(permutations, i, depth);
      makePermutation(number, choice, depth + 1);
      System.out.println("after [i, depth] : [" + i + "," + depth + "]");
      Collections.swap(permutations, i, depth);
    }
  }

  private void printPermutations(int depth) {
    System.out.print("---------------------\n");
    for (Integer permutation : permutations) {
      System.out.print(permutation + " ");
    }
    if (depth == 3) {
      System.out.print(" END");
    }
    permutationCount++;
    System.out.println("\n---------------------");
  }
}
