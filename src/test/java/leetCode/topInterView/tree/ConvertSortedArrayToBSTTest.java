package leetCode.topInterView.tree;

import java.util.PriorityQueue;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.tree
 * @since : 2023/04/12
 */
public class ConvertSortedArrayToBSTTest {

  @Test
  public void testPriorityQueue() {
    PriorityQueue<Integer> integers = new PriorityQueue<>();
    integers.add(3);
    integers.add(1);
    integers.add(2);
    integers.add(2);
    integers.add(2);

    System.out.println("integers = " + integers);
    int size = integers.size();
    for (int i = 0; i < size; i++) {
      System.out.println(integers.poll());
    }
    System.out.println("#######");
    System.out.println("integers = " + integers);
  }
}