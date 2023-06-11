package leetCode.topInterView.others;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.others
 * @since : 2023/06/11
 * @url : https://leetcode.com/problems/excel-sheet-column-number/description/?envType=featured-list&envId=top-interview-questions
 */
public class ExcelSheetColumnNumber {

  public static void main(String[] args) {
    ExcelSheetColumnNumberInterface solution = getSolution();
    int res = solution.titleToNumber("ZY");
    System.out.println("res = " + res);
  }

  public static ExcelSheetColumnNumberInterface getSolution() {
    return new ExcelSheetColumnNumberSolutionV1();
  }

  // A -> 1
  // AA -> Z + A = 26 + 1 = 27
  // AB -> Z + B = 26 + 2 = 28
  // AC -> Z + C = 26 + 3 = 29
  // AD -> Z + D = 26 + 4 = 30
  // ...
  // AZ -> Z + Z = 26 + 26 = 52
  // BA -> Z + Z + A = 26 + 26 + 1 = 53
  // ...
  // ZY -> 26 x 26 + 25 = 701
  // ...
  // ABC -> (26 x 26) x 1 + (26) x 2 + 3 =
  public static class ExcelSheetColumnNumberSolutionV1 implements ExcelSheetColumnNumberInterface {

    private final Map<Character, Integer> mp = new HashMap<>() {{
      put('A', 1); put('B', 2); put('C', 3); put('D', 4); put('E', 5);
      put('F', 6); put('G', 7); put('H', 8); put('I', 9); put('J', 10);
      put('K', 11); put('L', 12); put('M', 13); put('N', 14); put('O', 15);
      put('P', 16); put('Q', 17); put('R', 18); put('S', 19); put('T', 20);
      put('U', 21); put('V', 22); put('W', 23); put('X', 24); put('Y', 25);
      put('Z', 26);
    }};

    @Override
    public int titleToNumber(String columnTitle) {
      if (columnTitle.length() == 0 || columnTitle.length() > 7) {
        return 0;
      }
      char[] chs = columnTitle.toCharArray();
      int cnt = chs.length - 1;
      int res = 0;
      for (int i = 0; i < chs.length; i++) {
        res += calcul(chs[i], cnt--);
      }

      return res;
    }

    private int calcul(char ch, int cnt) {
      int num = mp.get(ch);
      if (cnt == 0) {
        return num;
      }

      int res = 1;
      for (int i = 0; i < cnt; i++) {
        res *= 26;
      }
      return res * num;
    }
  }

  public interface ExcelSheetColumnNumberInterface {

    int titleToNumber(String columnTitle);
  }
}
