package programers;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author : iyeong-gyo
 * @package : programers
 * @url : https://school.programmers.co.kr/learn/courses/30/lessons/135808
 * @since : 22.07.24
 */
public class FruitSeller {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] score = {1, 2, 3, 1, 2, 3, 1};
		int res = solution.solution(3, 4, score);

		// int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
		// int res = solution.solution(4, 3, score);

		System.out.println("res = " + res);
	}

	static class Solution {
		public int solution(int k, int m, int[] score) {
			int answer = 0;
			reverseSort(score);
			Stack<Integer> stk = new Stack<>();
			for (int i = 0; i < score.length; i++) {
				if (stk.size() == m) {
					Integer min = stk.peek();
					answer += (min * m);
					stk.clear();
					stk.push(score[i]);
				} else {
					stk.push(score[i]);
				}

				if ((score.length - 1) == i && stk.size() == m) {
					Integer min = stk.peek();
					answer += (min * m);
				}
			}

			return answer;
		}

		private void reverseSort(int[] array) {
			Arrays.sort(array);
			int n = array.length;
			for (int i = 0; i < n / 2; i++) {
				int temp = array[i];
				array[i] = array[n - 1 - i];
				array[n - 1 - i] = temp;
			}
		}
	}
}
