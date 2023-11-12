package leetcode.topinterview.array;

import java.util.HashMap;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Array
 * @since : 2023/03/06 https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/769/
 */
public class ValidSudoku {

  public static void main(String[] args) {
    ValidSudokuInterface solution = getSolution();
    char[][] board = {
        {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
        {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
        {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
        {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
        {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
        {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
        {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
        {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
        {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
    };
    System.out.println(solution.isValidSudoku(board));
  }

  public static ValidSudokuInterface getSolution() {
    return new ValidSudokuSolutionV1();
  }

  public static class ValidSudokuSolutionV1 implements ValidSudokuInterface {

    private HashMap<Character, Integer> strMap = new HashMap<>();

    @Override
    public boolean isValidSudoku(char[][] board) {
      return checkRow(board) && checkColumn(board) && checkGroup(board);
    }

    public boolean checkGroup(char[][] board) {
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
          }
          strMap.clear();
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

  public interface ValidSudokuInterface {

    boolean isValidSudoku(char[][] board);
  }
}

