package leetCode.topInterView.easy.Array;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.easy.Array
 * @since : 2023/03/06
 */
public class ValidSudoku {

  public static void main(String[] args) {
    ValidSudokuSolution solution = new ValidSudokuSolution();
    String[][] board = {
        {"5", "3", ".", ".", "7", ".", ".", ".", "."},
        {"6", ".", ".", "1", "9", "5", ".", ".", "."},
        {".", "9", "8", ".", ".", ".", ".", "6", "."},
        {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
        {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
        {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
        {".", "6", ".", ".", ".", ".", "2", "8", "."},
        {".", ".", ".", "4", "1", "9", ".", ".", "5"},
        {".", ".", ".", ".", "8", ".", ".", "7", "9"},
    };
//    System.out.println(solution.isValidSudoku(board));
  }
}

class ValidSudokuSolution {

  public boolean isValidSudoku(String[][] board) {
    return checkRow(board) && checkColumn(board) && checkGroup(board);
  }

  private boolean checkGroup(String[][] board) {
    return false;
  }

  private boolean checkColumn(String[][] board) {
    return false;
  }

  private boolean checkRow(String[][] board) {
    return false;
  }
}
