package repeat;

import leetcode.topinterview.strings.LongestPalindromicSubstring.LongestPalindromicSubstringInterface;

/**
 * @author : iyeong-gyo
 * @package : repeat
 * @since : 2023/05/28
 */
public class RepeatLongestPalindromicSubstring implements LongestPalindromicSubstringInterface {

  @Override
  public String longestPalindrome(String s) {
    if (s == null || s.length() < 2) {
      return s;
    }
    int len1 = 0;
    int len2 = 0;
    int start = 0;
    int end = 0;

    for (int i = 0; i < s.length(); i++) {
      len1 = expandAroundCenter(s, i, i);
      len2 = expandAroundCenter(s, i, i + 1);
      int len = Math.max(len1, len2);
      if (len > end - start) {
        start = i - ((len - 1) - 1);
        end = i + len / 2;
      }
    }

    return s.substring(start, end + 1);
  }

  private int expandAroundCenter(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    return right - left - 1;
  }
}
