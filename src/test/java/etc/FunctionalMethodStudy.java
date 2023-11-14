package etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : etc
 * @since : 13.11.23
 */
// 1. 일급 함수 (First-Class Functions)
// 2. 불변성 (Immutability)
// 3. 순수 함수 (Pure Functions)
// 4. 고차 함수 (Higher-Order Functions)
public class FunctionalMethodStudy {

  @Test
  public void test() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

    // 1. 일급 함수 (First-Class Functions)
    Function<Integer, Integer> square = x -> x * x;

    // 2. 불변성 (Immutability)
    // 여기서 numbers라는 리스트는 초기에 생성된 후에 변경되지 않습니다.
    // 대신, map 함수를 사용하여 새로운 리스트 squaredNumbers를 생성합니다.
    // map 함수에서는 기존 리스트를 변경하지 않고,
    // 각 원소에 대해 주어진 함수를 적용한 결과를 가지는 새로운 리스트를 반환합니다.
    List<Integer> squaredNumbers = map(numbers, square);
    System.out.println("Original List: " + numbers);
    System.out.println("Squared List: " + squaredNumbers);

    // 3. 순수 함수 (Pure Functions)
    List<Integer> cubedNumbers = map(numbers, x -> x * x * x);
    System.out.println("Cubed List: " + cubedNumbers);

    // 4. 고차 함수 (Higher-Order Functions)
    Function<Integer, Function<Integer, Integer>> add = x -> y -> x + y;
    int result = add.apply(3).apply(4);
    System.out.println("Result of Higher-Order Function: " + result);

  }

  // 4. 고차 함수 (Higher-Order Functions)
  private static List<Integer> map(
      List<Integer> list,
      Function<Integer, Integer> function
  ) {
    List<Integer> result = new ArrayList<>();
    for (Integer integer : list) {
      result.add(function.apply(integer));
    }
    return result;
  }
}
