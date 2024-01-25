package study.java.stream;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : study.stream
 * @since : 25.01.24
 */
public class StreamExample {

  @Test
  public void test1() {
    List<String> languages = List.of("Java", "Python", "JavaScript", "C#", "Ruby");
    List<String> filteredLanguages = languages.stream()
        .filter(lang -> lang.length() >= 4)
        .collect(Collectors.toList());

    System.out.println(filteredLanguages);
  }

  @Test
  public void test2() {
    List<String> fruits = List.of("Apple", "Banana", "Orange", "Grapes", "Mango");
    // 스트림 생성
    fruits.stream()
        .filter(fruit -> fruit.length() >= 6)   // 중간 연산: 길이가 6 이상인 과일만 필터링
        .map(fruit -> "Juicy " + fruit)         // 중간 연산: 각 과일에 "Juicy"를 추가
        .forEach(System.out::println)           // 최종 연산: 결과 출력
    ;
  }


}
