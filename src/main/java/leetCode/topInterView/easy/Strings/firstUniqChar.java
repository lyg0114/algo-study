package leetCode.topInterView.easy.Strings;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.easy.Strings
 * @since : 2023/03/08 https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/881/
 */
public class firstUniqChar {

  public static void main(String[] args) {
    FirstUniqCharSolution solution = new FirstUniqCharSolution();
    String str = "aabb";
    System.out.println(solution.firstUniqChar(str));
  }
}

class FirstUniqCharSolution {

  public int firstUniqChar(String s) {
    char[] chars = s.toCharArray();
    char tmp;
    for (int i = 0; i < chars.length; i++) {
      tmp = chars[i];
      for (int j = i + 1; j < chars.length; j++) {
        if (tmp == chars[j]) {
          break;
        }
        if (tmp != chars[j] && j == (chars.length - 1)) {
          return i;
        }
      }
    }
    return -1;
  }
}
