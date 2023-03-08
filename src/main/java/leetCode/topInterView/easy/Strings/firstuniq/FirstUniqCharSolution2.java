package leetCode.topInterView.easy.Strings.firstuniq;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.easy.Strings.firstuniq
 * @since : 2023/03/08
 */
class FirstUniqCharSolution2 implements FirstUniqCharSolution {

  @Override
  public int firstUniqChar(String s) {
    int[] cntArr = new int[26];
    for (int i = 0; i < s.length(); i++) {
      cntArr[s.charAt(i) - 'a']++;
    }
    for (int i = 0; i < s.length(); i++) {
      if (cntArr[s.charAt(i) - 'a'] == 1) {
        return i;
      }
    }
    return -1;
  }
}
