package leetcode.topinterview.strings;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Strings
 * @since : 2023/03/08 https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/879/
 */
public class ReverseString {

  public static void main(String[] args) {
    char[] str = {'H', 'a', 'n', 'a', 'h'};
    ReverseStringInterface solution = getSolution();
    solution.reverseString(str);
    for (char c : str) {
      System.out.print(c);
    }
  }

  public static ReverseStringSolution getSolution() {
    return new ReverseStringSolution();
  }

  public static class ReverseStringSolution implements ReverseStringInterface {

    @Override
    public void reverseString(char[] s) {
      char tmp;
      for (int i = 0; i < s.length / 2; i++) {
        tmp = s[i];
        s[i] = s[s.length - 1 - i];
        s[s.length - 1 - i] = tmp;
      }
    }
  }

  public interface ReverseStringInterface {

    void reverseString(char[] s);
  }
}

