package leetCode.topInterView.others;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.others
 * @since : 2023/06/11
 */
public class ExcelSheetColumnNumber {

  public static void main(String[] args) {
    ExcelSheetColumnNumberInterface solution = getSolution();
    int a = solution.titleToNumber("A");
    System.out.println("a = " + a);
  }

  public static ExcelSheetColumnNumberInterface getSolution() {
    return new ExcelSheetColumnNumberSolutionV1();
  }

  public static class ExcelSheetColumnNumberSolutionV1 implements ExcelSheetColumnNumberInterface {

    @Override
    public int titleToNumber(String columnTitle) {
      if (columnTitle.length() == 0 || columnTitle.length() > 7) {
        return -1;
      }
      return 0;
    }
  }

  public interface ExcelSheetColumnNumberInterface {

    int titleToNumber(String columnTitle);
  }
}
