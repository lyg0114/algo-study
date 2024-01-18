package others.codility.v2;

/**
 * @author : iyeong-gyo
 * @package : codility.v2
 * @since : 13.11.23
 */
public class CodilitySolution1 {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] A = {1, 2, 5, 9, 9};
//    int[] A = {1, 2, 3, 4, 5, 9, 9};
    int solution1 = solution.solution(A, 5);
    System.out.println("solution1 = " + solution1);
  }

  static class Solution {

    int solution(int[] A, int X) {
      int N = A.length;
      if (N == 0) {
        return -1;
      }
      int l = 0;
      int r = N - 1;
      while (l <= r) {
        int m = l + (r - l) / 2;
        if (A[m] == X) {
          return l;
        }
        if (A[m] > X) {
          r = m - 1;
        } else {
          l = m + 1;
        }
      }
      return -1;
    }
  }

//  static class Solution {
//
//    int solution(int[] A, int X) {
//      int N = A.length;
//      if (N == 0) {
//        return -1;
//      }
//      int l = 0;
//      int r = N - 1;
//      while (l < r) {
//        int m = l + (r - l) / 2;
//        if (A[m] == X) {
//          return m;
//        }
//        if (A[m] < X) {
//          l = m + 1;
//        } else {
//          r = m - 1;
//        }
//      }
//      return -1;
//    }
//  }
}
