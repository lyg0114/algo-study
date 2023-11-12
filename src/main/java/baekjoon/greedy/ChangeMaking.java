package baekjoon.greedy;

import java.util.Arrays;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.greedy
 * @since : 12.11.23
 */
public class ChangeMaking {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int coings[] = {500, 100, 50, 10};
    int amounts = 1260;

    int useCoinCnt = solution.solution(coings, amounts);
    System.out.println("useCoinCnt = " + useCoinCnt);
  }

  static class Solution {

    public int solution(int coings[], int amounts) {
      reverseArray(coings);
      int useCoinCnt = 0;
      int index = 0;

      while (amounts != 0) {
        if (coings[index] > amounts) {
          index++;
        }
        amounts = amounts - coings[index];
        useCoinCnt++;
      }
      return useCoinCnt;
    }

    private void reverseArray(int[] array) {
      Arrays.sort(array);
      int left = 0;
      int right = array.length - 1;
      while (left < right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
        left++;
        right--;
      }
    }
  }
}
