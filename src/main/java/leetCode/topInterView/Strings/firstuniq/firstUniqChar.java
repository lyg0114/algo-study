package leetCode.topInterView.Strings.firstuniq;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Strings
 * @since : 2023/03/08 https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/881/
 */
public class firstUniqChar {

  public static void main(String[] args) {
    FirstUniqCharSolution solution = new FirstUniqCharSolution2();
//    String str = "leetcode";
    String str = "aacbb";
    System.out.println(solution.firstUniqChar(str));
  }
}

