package leetCode.topInterView.Array;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Array
 * @since : 2023/03/02
 */
public class PlusOne {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4};
    PlusOneInterface solution = getSolution();
    int[] ints = solution.plusOne(nums);
    for (int anInt : ints) {
      System.out.print(anInt + ",");
    }
  }

  public static PlusOneInterface getSolution() {
    return new PlusOneSolutionV1();
  }

  public static class PlusOneSolutionV1 implements PlusOneInterface {

    @Override
    public int[] plusOne(int[] digits) {
      if (digits.length == 1 && digits[0] == 9) {
        int[] results = {1, 0};
        return results;
      }
      return plusOneCal(digits, digits.length - 1);
    }

    public int[] plusOneCal(int[] digits, int index) {
      if (digits[index] == 9 && index != 0) {
        digits[index] = 0;
        return plusOneCal(digits, index - 1);
      } else {
        digits[index] += 1;
        if (digits[index] == 10) {
          int[] results = new int[digits.length + 1];
          results[0] = 1;
          results[1] = 0;
          return results;
        }
      }
      return digits;
    }
  }

  public interface PlusOneInterface {

    int[] plusOne(int[] digits);
  }
}

