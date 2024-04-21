package study.algo;

import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : study.algo
 * @ref: baekjoon/page5/Question17143.java [line: 110]
 * @since : 21.04.24
 */
public class ContinueKeyword {

  @Test
  public void test() {
    for (int i = 0; i < 5; i++) {
      if (i == 2) {
        continue; // i가 2일 때는 현재 반복을 중지하고 다음 반복으로 넘어감
      }
      System.out.println("i: " + i);
    }
  }
}
