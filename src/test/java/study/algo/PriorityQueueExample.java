package study.algo;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : study
 * @since : 28.11.23
 */
public class PriorityQueueExample {

	@Test
	public void priorityQueuetest() {
		java.util.PriorityQueue<Integer> minPriorityQueue = new PriorityQueue<>();
		minPriorityQueue.add(3);
		minPriorityQueue.add(1);
		minPriorityQueue.add(4);
		minPriorityQueue.add(2);
		while (!minPriorityQueue.isEmpty()) {
			System.out.println(minPriorityQueue.poll());
		}
	}

	@Test
	public void reversePriorityQueuetest() {
		java.util.PriorityQueue<Integer> maxPriorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
		maxPriorityQueue.add(3);
		maxPriorityQueue.add(1);
		maxPriorityQueue.add(4);
		maxPriorityQueue.add(2);
		while (!maxPriorityQueue.isEmpty()) {
			System.out.println(maxPriorityQueue.poll());
		}
	}
}
