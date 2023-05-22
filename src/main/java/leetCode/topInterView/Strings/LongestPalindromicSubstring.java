package leetCode.topInterView.Strings;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Strings
 * @since : 2023/05/22
 */
public class LongestPalindromicSubstring {

  public static void main(String[] args) {
    LongestPalindromicSubstringInterface solution = getSolution();
    String input = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";

    long startTime = System.currentTimeMillis();
    String output = solution.longestPalindrome(input);
    System.out.println("output = " + output);
    long endTime = System.currentTimeMillis();
    long duration = endTime - startTime;
    System.out.println("실행 시간: " + duration + "ms");

    System.out.println("######################################################################");
    System.out.println("######################################################################");


    long startTime2 = System.currentTimeMillis();
    LongestPalindromicSubstringSolutionV2 solutionV2 = new LongestPalindromicSubstringSolutionV2();
    String s = solutionV2.longestPalindrome(input);
    System.out.println("s = " + s);
    long endTime2 = System.currentTimeMillis();
    long duration2 = endTime2 - startTime;
    System.out.println("실행 시간: " + duration2 + "ms");
  }

  private static LongestPalindromicSubstringInterface getSolution() {
    return new LongestPalindromicSubstringSolutionV1();
  }

  public static class LongestPalindromicSubstringSolutionV2 implements
      LongestPalindromicSubstringInterface {

    @Override
    public String longestPalindrome(String s) {
      if (s == null || s.length() < 2) {
        return s;
      }

      int start = 0;
      int end = 0;

      for (int i = 0; i < s.length(); i++) {
        int len1 = expandAroundCenter(s, i, i); // 홀수 길이의 팰린드롬 검사
        int len2 = expandAroundCenter(s, i, i + 1); // 짝수 길이의 팰린드롬 검사
        int len = Math.max(len1, len2);

        if (len > end - start) {
          start = i - (len - 1) / 2;
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

  public static class LongestPalindromicSubstringSolutionV1 implements
      LongestPalindromicSubstringInterface {

    @Override
    public String longestPalindrome(String s) {
      if (s == null || s.length() == 1) {
        return s;
      }
      if (s.length() == 2) {
        if (s.charAt(0) == s.charAt(1)) {
          return s;
        } else {
          return String.valueOf(s.charAt(0));
        }
      }

      int length = s.length();
      for (int i = length; i > 0; i--) {
        int start = 0;
        int end = i;
        while (end < length) {
          int innerStart = start;
          int innerEnd = end + 1;
          StringBuffer sb = new StringBuffer();
          while (innerStart < innerEnd) {
            sb.append(s.charAt(innerStart++));
          }
          String str = sb.toString();
          if (isPalindromStr(str)) {
            return str;
          }
          start++;
          end++;
        }
      }
      return String.valueOf(s.charAt(0));
    }

    public static boolean isPalindromStr(String str) {
      if (str.length() == 1) {
        return true;
      }

      int start = 0;
      int end = str.length() - 1;
      while (start < end) {
        if (str.charAt(start++) != str.charAt(end--)) {
          return false;
        }
      }
      return true;
    }
  }

  interface LongestPalindromicSubstringInterface {

    String longestPalindrome(String s);
  }
}
