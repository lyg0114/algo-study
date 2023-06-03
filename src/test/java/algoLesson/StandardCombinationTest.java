package algoLesson;

import algoLesson.StandardCombination.StandardCombinationRefV1;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : algoLesson
 * @since : 2023/06/03
 */
public class StandardCombinationTest {

  @Test
  public void test_StandardCombinationRefV1_combi_1() {
    StandardCombinationRefV1 combiV1 = new StandardCombinationRefV1();
    int[] nums = {1, 2, 3};
    int n = nums.length;
    int r = 3;
    combiV1.combi(-1, n, 2, nums);
  }

  @Test
  public void test_StandardCombinationRefV1_combi_2() {
    StandardCombinationRefV1 combiV1 = new StandardCombinationRefV1();
    int[] nums = {1, 2, 3, 4, 5};
    int n = nums.length;
    int r = 3;
    combiV1.combi(-1, n, 3, nums);
  }

}