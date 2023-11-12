package leetcode.topinterview.strings.firstuniq;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Strings.firstuniq
 * @since : 2023/03/08
 */
class FirstUniqCharSolution1 implements FirstUniqCharSolution {

  @Override
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
