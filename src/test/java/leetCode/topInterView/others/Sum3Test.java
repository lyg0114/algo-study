package leetCode.topInterView.others;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import leetCode.topInterView.others.Sum3.Sum3Interface;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.others
 * @since : 2023/05/24
 */
public class Sum3Test {

  @Test
  public void hashset_test1() {
    Sum3Interface solution = Sum3.getSolution();
    int[] nums = {-1, 0, 1, 2, -1, -4};
    List<List<Integer>> results = solution.threeSum(nums);

    List<List<Integer>> answers = new ArrayList<>();
    answers.add(Arrays.asList(-1,-1,2));
    answers.add(Arrays.asList(-1,0,1));

    assertEquals(results, answers);
  }

}


