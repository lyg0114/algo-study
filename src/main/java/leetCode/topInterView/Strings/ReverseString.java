package leetCode.topInterView.Strings;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Strings
 * @since : 2023/03/08 https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/879/
 */
public class ReverseString {

  public static void main(String[] args) {
    char[] str = {'H', 'a', 'n', 'a', 'h'};
    ReverseStringSolution solution = new ReverseStringSolution();
    solution.reverseString(str);
    for (char c : str) {
      System.out.print(c);
    }
  }
}

class ReverseStringSolution {

  public void reverseString(char[] s) {
    char tmp;
    for (int i = 0; i < s.length / 2; i++) {
      tmp = s[i];
      s[i] = s[s.length - 1 - i];
      s[s.length - 1 - i] = tmp;
    }
  }
}
