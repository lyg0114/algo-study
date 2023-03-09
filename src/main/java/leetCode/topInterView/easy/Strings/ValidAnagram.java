package leetCode.topInterView.easy.Strings;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.easy.Strings
 * @since : 2023/03/09
 */
public class ValidAnagram {

  public static void main(String[] args) {
    String s = "anagram";
    String t = "nagaram";
    ValidAnagramSolution solution = new ValidAnagramSolution();
    System.out.println(solution.isAnagram(s, t));
  }
}

class ValidAnagramSolution {

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







