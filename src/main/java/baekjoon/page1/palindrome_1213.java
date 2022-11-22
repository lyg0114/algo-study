package baekjoon.page1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.page1
 * @since : 2022/11/22
 */
public class palindrome_1213 {

  private List<String> palindromes = new ArrayList<String>();
  private String resultStr;
  private Set resultSets;

  public static void main(String[] ars) {
    palindrome_1213 palindrome = new palindrome_1213();
    palindrome.calculatePermutataion();
  }

  private void calculatePermutataion() {
    makeTargetLists();
    checkPalindrome(palindromes.size(), palindromes.size(), 0);
    ArrayList results = new ArrayList<>(resultSets);
    Collections.sort(results, String.CASE_INSENSITIVE_ORDER);
    try{
      System.out.println(results.get(0));
    } catch (Exception e){
      System.out.println("I'm Sorry Hansoo");
    }
  }

  public void makeTargetLists() {
    Scanner scan = new Scanner(System.in);
    String next = scan.next();
    char[] chars = next.toCharArray();
    palindromes = new ArrayList<String>();
    for (int i = 0; i < chars.length; i++) {
      palindromes.add(String.valueOf(chars[i]));
    }
    StringBuilder sb = new StringBuilder();
    for (String s : palindromes) {
      sb.append(s);
    }
    resultStr = sb.toString();
    resultSets = new HashSet<String>();
  }

  public void checkPalindrome(int number, int choice, int depth) {
    if (choice == depth) {
      if (isPalindrome()) {
        StringBuilder sb = new StringBuilder();
        for (String s : palindromes) {
          sb.append(s);
        }
        String current = sb.toString();
        if (resultStr.compareTo(current) > 0) {
          resultStr = current;
        }
        resultSets.add(current);
      }
      return;
    }
    for (int i = depth; i < number; i++) {
      Collections.swap(palindromes, i, depth);
      checkPalindrome(number, choice, depth + 1);
      Collections.swap(palindromes, i, depth);
    }
  }

  private boolean isPalindrome() {
    boolean isPalindrome = false;
    for (int i = 0; i < (palindromes.size() / 2); i++) {
      if (palindromes.get(i).equals(palindromes.get((palindromes.size() - 1) - i))) {
        isPalindrome = true;
      } else {
        return false;
      }
    }
    return isPalindrome;
  }
}
