package codility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : iyeong-gyo
 * @package : codility
 * @since : 11.11.23
 */
public class CodilitySolution1 {

  static String longetStr = "";

  public static void main(String[] args) {
    int AA = 0;
    int AB = 0;
    int BB = 10;
    String longestStr = solution(AA, AB, BB);
    System.out.println("longestStr = " + longestStr);
  }

  // AA, AB, BB 를 조합하여 나열하는 문제
  private static String solution(int AA, int AB, int BB) {
    List<String> strings = new ArrayList<>();
    makeTotalStrs(AA, "AA", strings);
    makeTotalStrs(AB, "AB", strings);
    makeTotalStrs(BB, "BB", strings);

    for (int i = 1; i < strings.size() + 1; i++) {
      permuteRec(0, strings.size(), i, strings);
    }

    return longetStr;
  }

  public static void permuteRec(int depth, int n, int r, List<String> strings) {
    String result = getCurrentLongestStr(r, strings);
    checkLongetstStr(result);
    if (r == depth) {
      return;
    }
    for (int i = depth; i < n; i++) {
      Collections.swap(strings, i, depth);
      permuteRec(depth + 1, n, r, strings);
      Collections.swap(strings, i, depth);
    }
  }

  private static void checkLongetstStr(String result) {
    if ((longetStr.length() <= result.length()) &&
        !(result.contains("AAA")) && !(result.contains("BBB"))
    ) {
      longetStr = result;
    }
  }

  private static String getCurrentLongestStr(int r, List<String> strings) {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < r; i++) {
      sb.append(strings.get(i));
    }
    return sb.toString();
  }

  private static void makeTotalStrs(int cnt, String targetStr, List<String> strings) {
    for (int i = 0; i < cnt; i++) {
      strings.add(targetStr);
    }
  }
}
