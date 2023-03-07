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

  private HashMap<Character, Integer> strMap = new HashMap<>();

  public boolean isValidSudoku(char[][] board) {
    return checkRow(board) && checkColumn(board) && checkGroup(board);
  }

  private boolean checkGroup(char[][] board) {
    return false;
  }

  public boolean checkColumn(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (strMap.containsKey(board[j][i])) {
          return false;
        }
        if (board[j][i] != '.') {
          strMap.put(board[j][i], 1);
        }
      }
      strMap.clear();
    }
    return true;
  }

  public boolean checkRow(char[][] board) {
    for (char[] chars : board) {
      for (char aChar : chars) {
        if (strMap.containsKey(aChar)) {
          return false;
        }
        if (aChar != '.') {
          strMap.put(aChar, 1);
        }
      }
      strMap.clear();
    }
    return true;
  }
}
