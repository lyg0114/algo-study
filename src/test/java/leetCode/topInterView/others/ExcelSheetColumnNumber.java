package leetCode.topInterView.others;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.others
 * @since : 2023/06/11
 */
public class ExcelSheetColumnNumber {

  public static void main(String[] args) {
    ExcelSheetColumnNumberInterface solution = getSolution();
  }

  public static ExcelSheetColumnNumberInterface getSolution() {
    return new ExcelSheetColumnNumberSolutionV1();
  }

  public static class ExcelSheetColumnNumberSolutionV1 implements ExcelSheetColumnNumberInterface {

    @Override
    public int titleToNumber(String columnTitle) {
      return 0;
    }
  }

  public interface ExcelSheetColumnNumberInterface {

    int titleToNumber(String columnTitle);
  }
}
