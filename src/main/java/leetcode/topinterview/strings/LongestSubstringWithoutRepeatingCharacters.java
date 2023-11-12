package leetcode.topinterview.strings;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Strings
 * @since : 2023/05/20
 */
public class LongestSubstringWithoutRepeatingCharacters {

  public static void main(String[] args) {
    LongestSubstringWithoutRepeatingCharactersInterface solution = getSolution();
//    String s = "dvdf";
//    String s = "dkavaf";
    String s = "pwwkew";

    int results = solution.lengthOfLongestSubstring(s);
    System.out.println("results = " + results);
  }

  public static LongestSubstringWithoutRepeatingCharactersInterface getSolution() {
    return new LongestSubstringWithoutRepeatingCharactersInterfaceSolutionV2();
  }

  public static class LongestSubstringWithoutRepeatingCharactersInterfaceSolutionV2 implements
      LongestSubstringWithoutRepeatingCharactersInterface {

    @Override
    public int lengthOfLongestSubstring(String s) {
      int n = s.length();
      int left = 0;
      int right = 0;
      int maxLength = 0;
      HashSet<Character> uniqueCharsSet = new HashSet<>();

      while (right < n) {
        if (!uniqueCharsSet.contains(s.charAt(right))) {
          uniqueCharsSet.add(s.charAt(right));
          maxLength = Math.max(maxLength, uniqueCharsSet.size());
          right++;
        } else {
          uniqueCharsSet.remove(s.charAt(left));
          left++;
        }
      }

      return maxLength;
    }
  }

  public static class LongestSubstringWithoutRepeatingCharactersInterfaceSolutionV1 implements
      LongestSubstringWithoutRepeatingCharactersInterface {

    @Override
    public int lengthOfLongestSubstring(String s) {
      if (s == null) {
        return 0;
      }
      if (s.length() == 1) {
        return 1;
      }
      if (s.length() == 2) {
        if (s.charAt(0) != s.charAt(1)) {
          return 2;
        } else {
          return 1;
        }
      }

      HashMap<Character, Integer> tmpMaps = new HashMap<>();
      String tmp = "";
      StringBuffer bf = new StringBuffer();
      for (int i = 0; i < s.length(); i++) {
        if (!tmpMaps.containsKey(s.charAt(i))) {
          tmpMaps.put(s.charAt(i), 1);
        } else {
          for (Character ch : tmpMaps.keySet()) {
            bf.append(ch);
          }
          if (tmp.length() < bf.toString().length()) {
            tmp = bf.toString();
          }
          tmpMaps.remove(s.charAt(i));
          bf.setLength(0);
          i--;
        }
      }

      if (tmpMaps.size() > 0) {
        bf.setLength(0);
        for (Character ch : tmpMaps.keySet()) {
          bf.append(ch);
        }
        String s1 = bf.toString();
        if (s1.length() > tmp.length()) {
          tmp = s1;
        }
      }
      System.out.println("tmp = " + tmp);
      return tmp.length();
    }
  }

  interface LongestSubstringWithoutRepeatingCharactersInterface {

    int lengthOfLongestSubstring(String s);
  }
}

