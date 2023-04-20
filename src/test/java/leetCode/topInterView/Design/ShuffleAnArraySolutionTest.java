package leetCode.topInterView.Design;

import java.util.Random;
import org.junit.Test;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Design
 * @since : 2023/04/20
 */
public class ShuffleAnArraySolutionTest {

  @Test
  public void makeRandomNumberTest() {
    Random random = new Random();
    System.out.println(random.nextInt());
    System.out.println(random.nextInt());
    System.out.println(random.nextInt());
  }

  @Test
  public void makeRandomNumberTest2() {
    Random random = new Random();
    System.out.println(random.nextInt(3) + 1);
    System.out.println(random.nextInt(3) + 1);
    System.out.println(random.nextInt(3) + 1);
    System.out.println(random.nextInt(3) + 1);
  }

  @Test
  public void ShufflArrayTest() {
    int[] nums = {1, 2, 3, 4, 5, 6};
    ShuffleAnArraySolution solution = new ShuffleAnArraySolution(nums);
    int[] shuffle = solution.shuffle();
    for (int i = 0; i < shuffle.length; i++) {
      System.out.println("shuffle[i] = " + shuffle[i]);
    }
  }
}