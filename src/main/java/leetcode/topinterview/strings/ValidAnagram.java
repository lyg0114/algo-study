package leetcode.topinterview.strings;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Strings
 * @since : 2023/03/09
 */
public class ValidAnagram {

  public static void main(String[] args) {
    String s = "anagram";
    String t = "nagaram";
    ValidAnagramInterface solution = getSolution();
    System.out.println(solution.isAnagram(s, t));
  }

  public static ValidAnagramInterface getSolution() {
    return new ValidAnagramSolutionV1();
  }

  static class ValidAnagramSolutionV1 implements ValidAnagramInterface {

    public boolean isAnagram(String s, String t) {
      int[] countArrs1 = getCountArrs(s);
      int[] countArrs2 = getCountArrs(t);
      int totalCnt = countArrs1.length == countArrs2.length ? countArrs1.length : -1;

      if (totalCnt == -1) {
        return false;
      }
      for (int i = 0; i < totalCnt; i++) {
        if (countArrs1[i] != countArrs2[i]) {
          return false;
        }
      }
      return true;
    }

    private int[] getCountArrs(String str) {
      int[] cntArr = new int[26];
      for (int i = 0; i < str.length(); i++) {
        cntArr[str.charAt(i) - 'a']++;
      }
      return cntArr;
    }
  }

  public interface ValidAnagramInterface {

    boolean isAnagram(String s, String t);
  }
}


