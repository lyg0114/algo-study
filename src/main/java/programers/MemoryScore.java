package programers;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : iyeong-gyo
 * @package : programers
 * @url : https://school.programmers.co.kr/learn/courses/30/lessons/176963?language=java
 * @since : 20.07.24
 */
public class MemoryScore {

	public static void main(String[] args) {
		String[] name = {"may", "kein", "kain", "radi"};
		int[] yearning = {5, 10, 1, 3};
		String[][] photo = {{"may", "kein", "kain", "radi"},
			{"may", "kein", "brin", "deny"},
			{"kon", "kain", "may", "coni"}
		};

		Solution solution = new Solution();
		int[] solution1 = solution.solution(name, yearning, photo);
		for (int i : solution1) {
			System.out.println("i = " + i);
		}
	}

	static class Solution {
		public int[] solution(String[] name, int[] yearning, String[][] photo) {
			if (name.length != yearning.length) {
				return null;
			}

			Map<String, Integer> score = new HashMap<>();
			for (int i = 0; i < name.length; i++) {
				score.put(name[i], yearning[i]);
			}

			int[] answer = new int[photo.length];
			for (int i = 0; i < photo.length; i++) {
				Integer sum = 0;
				for (int j = 0; j < photo[i].length; j++) {
					Integer i1 = score.get(photo[i][j]);
					sum += i1 == null ? 0 : i1;
				}
				answer[i] = sum;
			}

			return answer;
		}
	}
}
