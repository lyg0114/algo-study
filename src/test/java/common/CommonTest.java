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

  @Test
  public void MathPowTest(){
    int ret = (int) Math.pow(10, 0);
    System.out.println("ret = " + ret);
    int ret1 = (int) Math.pow(10, 1);
    System.out.println("ret1 = " + ret1);
    int ret2 = (int) Math.pow(10, 2);
    System.out.println("ret2 = " + ret2);
  }
}