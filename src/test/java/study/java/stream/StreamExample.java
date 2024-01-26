package study.java.stream;

import java.util.List;
import java.util.Map;
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

  @Test
  public void test3() {
    // 예제를 위한 데이터 리스트
    List<String> fruits = List.of("Apple", "Banana", "Orange", "Grapes", "Mango");
    Map<String, Integer> fruitLengthMap = fruits.stream()  // 스트림을 사용하여 각 과일과 그 길이를 매핑한 후 HashMap으로 변환
        .collect(Collectors.toMap(
            fruit -> fruit,       // 키 매핑: 과일 이름
            String::length        // 값 매핑: 과일 이름의 길이
        ));

    System.out.println(fruitLengthMap);
  }

  @Test
  public void extractMapByLastName() {
    List<String> fruits = List.of(
        "Apple Lee", "Banana Park", "Orange Lee", "Grapes Kim", "Mango Park",
        "yglee", "gabeen"
    );

    Map<String, List<String>> result = fruits.stream()
        .collect(Collectors.groupingBy(fruit -> {
          String[] parts = fruit.split(" ");
          if (parts.length > 1) {
            return parts[1];
          } else {
            return "onlyName";
          }
        }));

    result.forEach((lastName, names) -> {
      System.out.println(lastName + ": " + names);
    });
  }
}
