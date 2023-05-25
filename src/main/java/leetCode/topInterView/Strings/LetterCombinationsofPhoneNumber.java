package leetCode.topInterView.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Strings
 * @since : 2023/05/25
 */
public class LetterCombinationsofPhoneNumber {

  public static void main(String[] args) {
    LetterCombinationsofPhoneNumberInterface solution = getSolution();
    List<String> strings = solution.letterCombinations("22");
    System.out.println("strings = " + strings);
  }

  private static LetterCombinationsofPhoneNumberInterface getSolution() {
    return new LetterCombinationsofPhoneNumberSolutionV1();
  }

  public static class LetterCombinationsofPhoneNumberSolutionV1 implements
      LetterCombinationsofPhoneNumberInterface {

    private final Map<Character, String> pnm = new HashMap<>() {{
      put('2', "abc");
      put('3', "def");
      put('4', "ghi");
      put('5', "jkl");
      put('6', "mno");
      put('7', "pqrs");
      put('8', "tuv");
      put('9', "wxyz");
    }};

    private final Map<Character, Character> reversePnm = new HashMap<>() {{
      put('a', '2');
      put('b', '2');
      put('c', '2');
      put('d', '3');
      put('e', '3');
      put('f', '3');
      put('g', '4');
      put('h', '4');
      put('i', '4');
      put('j', '5');
      put('k', '5');
      put('l', '5');
      put('m', '6');
      put('n', '6');
      put('o', '6');
      put('p', '7');
      put('q', '7');
      put('r', '7');
      put('s', '7');
      put('t', '8');
      put('u', '8');
      put('v', '8');
      put('w', '9');
      put('x', '9');
      put('y', '9');
      put('z', '9');
    }};

    @Override
    public List<String> letterCombinations(String digits) {
      if(digits.equals(""))
        return new ArrayList<>();

      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < digits.length(); i++) {
        sb.append(pnm.get(digits.charAt(i)));
      }

      String converStr = sb.toString();
      List<List<Character>> lists = generateCombinations(converStr.toCharArray(), digits.length());

      List<String> results = new ArrayList<>();
      for (List<Character> list : lists) {
        StringBuffer bf = new StringBuffer();
        for (Character character : list) {
          bf.append(character);
        }
        results.add(bf.toString());
      }

      return results;
    }

    public List<List<Character>> generateCombinations(char[] arr, int r) {
      List<List<Character>> combinations = new ArrayList<>();
      List<Character> combination = new ArrayList<>();
      generateCombinations(arr, r, 0, combination, combinations);
      return combinations;
    }

    private void generateCombinations(char[] arr, int r, int index,
        List<Character> combination, List<List<Character>> combinations) {
      if (combination.size() == r && checkBtn(combination)) {
        combinations.add(new ArrayList<>(combination));
        return;
      }

      for (int i = index; i < arr.length; i++) {
        combination.add(arr[i]);
        generateCombinations(arr, r, i + 1, combination, combinations);
        combination.remove(combination.size() - 1);
      }
    }

    private boolean checkBtn(List<Character> combination) {
      HashMap<Character, Integer> tmp = new HashMap<>();
      for (Character character : combination) {
        Character ch = reversePnm.get(character);
        if (tmp.size() == 0) {
          tmp.put(ch, 1);
        } else {
          if (tmp.get(ch) != null && tmp.get(ch) > 0) {
            return false;
          }
        }
      }
      return true;
    }
  }

  interface LetterCombinationsofPhoneNumberInterface {

    List<String> letterCombinations(String digits);
  }
}
