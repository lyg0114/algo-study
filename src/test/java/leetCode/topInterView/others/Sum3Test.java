package leetCode.topInterView.others;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.others
 * @since : 2023/05/24
 */
public class Sum3Test {

  @Test
  public void set_compare_test() {
    Set<Integer> set1 = new HashSet<Integer>();
    set1.add(0);
    set1.add(1);
    set1.add(-1);

    Set<Integer> set2 = new HashSet<Integer>();
    set2.add(-1);
    set2.add(0);
    set2.add(1);
    assertEquals(set1, set2);
  }

}