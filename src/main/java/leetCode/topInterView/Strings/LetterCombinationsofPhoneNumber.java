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
    List<String> strings = solution.letterCombinations("222");
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

    @Override
    public List<String> letterCombinations(String digits) {
      if (digits == null || digits.equals("")) {
        return new ArrayList<>();
      }

      char[] chars = convertToChar(digits);
      List<String> results;
      switch (digits.length()) {
        case 1: results = calculateLength1(chars); break;
        case 2: results = calculateLength2(chars, digits); break;
        case 3: results = calculateLength3(chars, digits); break;
        case 4: results = calculateLength4(chars, digits); break;
        default: results = new ArrayList<>();
      }

      return results;
    }

    private List<String> calculateLength1(char[] chars) {
      ArrayList<String> strs = new ArrayList<>();
      for (int i = 0; i < chars.length; i++) {
        strs.add(String.valueOf(chars[i]));
      }
      return strs;
    }

    private List<String> calculateLength2(char[] chars, String digits) {
      String s = pnm.get(digits.charAt(0));
      ArrayList<String> strs = new ArrayList<>();
      for (int i = 0; i < s.length(); i++) {
        for (int j = s.length(); j < chars.length; j++) {
          StringBuffer sb = new StringBuffer();
          sb.append(chars[i]);
          sb.append(chars[j]);
          strs.add(sb.toString());
        }
      }
      return strs;
    }

    private List<String> calculateLength3(char[] chars, String digits) {
      int firstLength = pnm.get(digits.charAt(0)).length();
      int secondLength = pnm.get(digits.charAt(1)).length() + firstLength;
      ArrayList<String> strs = new ArrayList<>();
      for (int i = 0; i < firstLength; i++) {
        for (int j = firstLength; j < secondLength; j++) {
          for (int k = secondLength; k < chars.length; k++) {
            StringBuffer sb = new StringBuffer();
            sb.append(chars[i]);
            sb.append(chars[j]);
            sb.append(chars[k]);
            strs.add(sb.toString());
          }
        }
      }
      return strs;
    }

    private List<String> calculateLength4(char[] chars, String digits) {
      int firstLength = pnm.get(digits.charAt(0)).length();
      int secondLength = pnm.get(digits.charAt(1)).length() + firstLength;
      int thirdLength = pnm.get(digits.charAt(2)).length() + secondLength;
      ArrayList<String> strs = new ArrayList<>();
      for (int i = 0; i < firstLength; i++) {
        for (int j = firstLength; j < secondLength; j++) {
          for (int k = secondLength; k < thirdLength; k++) {
            for (int l = thirdLength; l < chars.length; l++) {
              StringBuffer sb = new StringBuffer();
              sb.append(chars[i]);
              sb.append(chars[j]);
              sb.append(chars[k]);
              sb.append(chars[l]);
              strs.add(sb.toString());
            }
          }
        }
      }
      return strs;
    }

    private char[] convertToChar(String digits) {
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < digits.length(); i++) {
        sb.append(pnm.get(digits.charAt(i)));
      }
      return sb.toString().toCharArray();
    }
  }

  interface LetterCombinationsofPhoneNumberInterface {

    List<String> letterCombinations(String digits);
  }
}
