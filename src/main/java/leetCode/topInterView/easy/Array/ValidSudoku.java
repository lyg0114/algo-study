package leetCode.topInterView.easy.Array;

import java.util.HashMap;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.easy.Array
 * @since : 2023/03/06
 */
public class ValidSudoku {

  public static void main(String[] args) {
    ValidSudokuSolution solution = new ValidSudokuSolution();
    char[][] board = {
        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
    };
//    System.out.println(solution.isValidSudoku(board));
  }
}

class ValidSudokuSolution {

  private HashMap<String, Object> strMap = new HashMap<>();

  public boolean isValidSudoku(char[][] board) {
    return checkRow(board) && checkColumn(board) && checkGroup(board);
  }

  private boolean checkGroup(char[][] board) {
    return false;
  }

  private boolean checkColumn(char[][] board) {
    return false;
  }

  private boolean checkRow(char[][] board) {
    return false;
  }
}
