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
    System.out.println(solution.isValidSudoku(board));
  }
}

class ValidSudokuSolution {

  private HashMap<Character, Integer> strMap = new HashMap<>();

  public boolean isValidSudoku(char[][] board) {
    return checkRow(board) && checkColumn(board) && checkGroup(board);
  }

  public boolean checkGroup(char[][] board) {
    //0,0 //3,0 //6,0
    //0,3 //3,3 //6,3
    //0,6 //3,6 //6,6
    for (int i = 0; i < 7; i += 3) {
      for (int j = 0; j < 7; j += 3) {

        for (int k = i; k < i + 3; k++) {
          for (int l = j; l < j + 3; l++) {
            if (strMap.containsKey(board[k][l])) {
              return false;
            }
            if (board[k][l] != '.') {
              strMap.put(board[k][l], 1);
            }
          }
          strMap.clear();
        }

      }
    }
    return true;
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
