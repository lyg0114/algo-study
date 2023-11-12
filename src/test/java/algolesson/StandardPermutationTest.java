package algolesson;

import algolesson.StandardPermutation.StandardPermutationRefV1;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : algoLesson
 * @since : 2023/06/03
 */
public class StandardPermutationTest {

  @Test
  public void test_StandardCombination_permuteRec_1() {
    StandardPermutationRefV1 perV1 = new StandardPermutationRefV1();
    int[] nums = {1, 2, 3};
    perV1.permuteRec(0, nums.length, 3, nums);
  }

  @Test
  public void test_StandardCombination_permuteRec_2() {
    StandardPermutationRefV1 perV1 = new StandardPermutationRefV1();
    int[] nums = {1, 2, 3, 4, 5};
    perV1.permuteRec(0, nums.length, 5, nums);
  }

  @Test
  public void test_StandardCombination_permuteRec_3() {
    StandardPermutationRefV1 perV1 = new StandardPermutationRefV1();
    int[] nums = {1, 2, 2, 3}; // 중복 발생 --> 필요시 중복을 제거하는 로직을 추가
    perV1.permuteRec(0, nums.length, 4, nums);
  }
}