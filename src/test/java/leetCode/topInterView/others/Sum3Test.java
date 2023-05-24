package leetCode.topInterView.others;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.others
 * @since : 2023/05/24
 */
public class Sum3Test {

  @Test
  public void hashset_test1() {
    Set<List<Integer>> s = new HashSet<>();
    s.add(Arrays.asList(1, 2, 3));
    s.add(Arrays.asList(1, 2, 3));
    s.add(Arrays.asList(4, 5, 1));
    System.out.println("s = " + s);
  }

  @Test
  public void hashset_test2() {
    Set<List<Integer>> s = new HashSet<>();
    s.add(Arrays.asList(1, 2, 3));
    s.add(Arrays.asList(-11, 2, 3));
    s.add(Arrays.asList(4, 5, 1));
    System.out.println("s = " + s);
  }
}


