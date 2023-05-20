package leetCode.topInterView.Strings;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Strings
 * @since : 2023/05/20
 */
public class LongestSubstringWithoutRepeatingCharacters {

  public static void main(String[] args) {
    LongestSubstringWithoutRepeatingCharactersInterface solution = getSolution();

    String s = "abcabcbb";
    int results = solution.lengthOfLongestSubstring(s);
    System.out.println("results = " + results);
  }

  public static LongestSubstringWithoutRepeatingCharactersInterface getSolution() {
    return new LongestSubstringWithoutRepeatingCharactersInterfaceSolution();
  }

  public static class LongestSubstringWithoutRepeatingCharactersInterfaceSolution implements
      LongestSubstringWithoutRepeatingCharactersInterface {

    @Override
    public int lengthOfLongestSubstring(String s) {
      return 0;
    }
  }

  interface LongestSubstringWithoutRepeatingCharactersInterface {

    int lengthOfLongestSubstring(String s);
  }
}

