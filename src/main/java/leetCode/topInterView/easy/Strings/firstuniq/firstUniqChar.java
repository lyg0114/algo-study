package leetCode.topInterView.easy.Strings.firstuniq;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.easy.Strings
 * @since : 2023/03/08 https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/881/
 */
public class firstUniqChar {

  public static void main(String[] args) {
    FirstUniqCharSolution solution = new FirstUniqCharSolution1();
    String str = "aabb";
    System.out.println(solution.firstUniqChar(str));
  }
}

