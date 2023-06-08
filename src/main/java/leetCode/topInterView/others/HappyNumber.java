package leetCode.topInterView.others;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.others
 * @since : 2023/06/08
 */
public class HappyNumber {

  public static void main(String[] args) {
    HappyNumberInterface solution = getSolution();
  }

  public static HappyNumberInterface getSolution() {
    return new HappyNumberSolutionV1();
  }

  public static class HappyNumberSolutionV1 implements HappyNumberInterface {

    @Override
    public boolean isHappy(int n) {
      return false;
    }
  }


  public interface HappyNumberInterface {

    boolean isHappy(int n);
  }

}
