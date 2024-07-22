package programers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : iyeong-gyo
 * @package : programers
 * @url : https://school.programmers.co.kr/learn/courses/30/lessons/131130
 * @since : 22.07.24
 */
public class PlayAlone {
	public static void main(String[] args) {
		int[] cards = {8, 6, 3, 7, 2, 5, 1, 4};
		PlayAlone playAlone = new PlayAlone();
		int solution = playAlone.solution(cards);
		System.out.println("solution = " + solution);
	}

	static class Box {
		int num;
		boolean isOpen = false;
		int group = -1;

		public Box(int num) {
			this.num = num;
		}
	}

	public int solution(int[] cards) {
		int answer = 0;
		List<Box> boxs = new ArrayList<>();
		for (int card : cards) {
			boxs.add(new Box(card));
		}

		boolean isFirst = true;
		for (int i = 0; i < boxs.size(); i++) {
			int group = 0;
			while (isNotClear(boxs)) {
				group++;
				int start = getStartIdx(boxs, isFirst, i);
				isFirst = false;
				openBox(boxs, start, group);
			}

			int tmp = makeResult(boxs);
			answer = Math.max(tmp, answer);
			clearBox(boxs);
			isFirst = true;
		}

		return answer;
	}

	private void clearBox(List<Box> boxs) {
		for (Box box : boxs) {
			box.isOpen = false;
		}
	}

	private void openBox(List<Box> boxs, int index, int group) {
		Box box = boxs.get(index);
		if (box.isOpen) {
			return;
		}
		box.group = group;
		box.isOpen = true;
		openBox(boxs, box.num - 1, group);
	}

	private int makeResult(List<Box> boxs) {
		List<Long> topTwoCounts = boxs.stream()
			.collect(Collectors.groupingBy(
				box -> box.group,
				Collectors.counting()
			)).values()
			.stream()
			.sorted(Collections.reverseOrder())
			.limit(2)
			.toList();

		long result = topTwoCounts.size() < 2 ? 0 : topTwoCounts.get(0) * topTwoCounts.get(1);
		return (int)result;
	}

	private int getStartIdx(List<Box> boxs, boolean isFirst, int idx) {
		if (isFirst) {
			return idx;
		}

		for (int index = 0; index < boxs.size(); index++) {
			if (!boxs.get(index).isOpen) {
				return index;
			}
		}

		return -1;
	}

	private boolean isNotClear(List<Box> boxs) {
		for (Box box : boxs) {
			if (!box.isOpen) {
				return true;
			}
		}
		return false;
	}
}
