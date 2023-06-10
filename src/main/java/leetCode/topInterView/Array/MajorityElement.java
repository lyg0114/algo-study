package leetCode.topInterView.Array;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Array
 * @since : 2023/06/10
 */
public class MajorityElement {

  public static void main(String[] args) {
    MajorityElementInterface solution = getSolution();
  }

  public static MajorityElementInterface getSolution() {
    return new MajorityElementSolutionV1();
  }

  public static class MajorityElementSolutionV1 implements MajorityElementInterface {

   @Override
    public int majorityElement(int[] nums) {
      return 0;
    }
  }

  public interface MajorityElementInterface {

    int majorityElement(int[] nums);
  }
}
