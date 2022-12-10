package common;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : common
 * @since : 2022/12/11
 */
public class QueueTest {

  @Test
  public void queueTest(){
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(1);
    queue.add(2);
    queue.add(3);
    queue.add(4);
    System.out.println("queue.poll() = " + queue.poll());
    System.out.println(queue.peek());
    System.out.println("queue.size() = " + queue.size());
  }
}
