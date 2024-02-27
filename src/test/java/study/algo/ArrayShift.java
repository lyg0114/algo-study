package study.algo;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : study.algo
 * @since : 27.02.24
 */
public class ArrayShift {
  @Test
  public void test() {
    List<Integer> slice = new ArrayList<>();
    slice.add(1);
    slice.add(2);
    slice.add(3);
    slice.add(4);
    slice.add(5);

    System.out.println(slice);
    shiftRight(slice);
    System.out.println(slice);
    shiftLeft(slice);
    System.out.println(slice);
  }

  private static void shiftRight(List<Integer> list) {
    if (list.size() <= 1) {
      return;
    }
    // 리스트의 마지막 요소를 저장하고 삭제
    Integer lastElement = list.remove(list.size() - 1);
    // 리스트의 첫 번째 위치에 저장한 마지막 요소를 삽입
    list.add(0, lastElement);
  }

  private static void shiftLeft(List<Integer> list) {
    if (list.size() <= 1) {
      return;
    }
    // 리스트의 첫번째 요소를 저장하고 삭제
    Integer firstElement = list.remove(0);
    // 리스트의 마지막 위치에 저장한 마지막 요소를 삽입
    list.add(list.size(), firstElement);
  }
}
