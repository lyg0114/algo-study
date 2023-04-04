package leetCode.topInterView.Strings;

class LongestCommonPrefixSolution2 {

  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }

    String prefix = strs[0]; // 첫 번째 문자열을 기준으로 설정합니다.

    for (int i = 1; i < strs.length; i++) {
      // 현재 문자열이 이전 접두사와 일치하는 위치를 찾습니다.
      while (strs[i].indexOf(prefix) != 0) {
        // 일치하지 않는 경우 현재 접두사를 하나씩 줄여나갑니다.
        prefix = prefix.substring(0, prefix.length() - 1);
        if (prefix.isEmpty()) {
          return ""; // 접두사가 없는 경우 공백 문자열을 반환합니다.
        }
      }
    }

    return prefix;
  }
}









