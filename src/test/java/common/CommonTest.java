package common;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class CommonTest {
  @Test
  public void SORT_CASE_INSENSITIVE_ORDER_TEST() {
    List<String> strings = Arrays.asList("ABBA", "BAAB");
    Collections.sort(strings, String.CASE_INSENSITIVE_ORDER);
    System.out.println("strings.get(0) = " + strings.get(0));
  }
}