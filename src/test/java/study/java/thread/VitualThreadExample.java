package study.java.thread;

import java.util.concurrent.ThreadFactory;
import java.lang.Thread;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : study.java.thread
 * @since : 16.03.24
 */
public class VitualThreadExample {
  @Test
  public void test1() {
    Runnable printThread = () -> System.out.println(Thread.currentThread());

    ThreadFactory virtualThreadFactory = Thread.ofVirtual().factory();
    ThreadFactory kernelThreadFactory = Thread.ofVirtual().factory();

    Thread virtualThread = virtualThreadFactory.newThread(printThread);
    Thread kernelThread = kernelThreadFactory.newThread(printThread);

    virtualThread.start();
    kernelThread.start();
  }
}
