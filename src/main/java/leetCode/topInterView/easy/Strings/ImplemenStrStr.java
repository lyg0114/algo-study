package leetCode.topInterView.easy.Strings;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.easy.Strings
 * @since : 2023/03/14
 */

/*
   1. needle 을 순회 한다.
   2. needle의 문자가 haystack에 있는지 확인한다. a
   3.1 있으면 haystack의 인덱스를 저장하고, needle의 다음 문자를 가져온다.
   3.2 가져온 needle의 문자와 haystack의 저장된 인덱스 + 1 의 문자를 확인한다.
   4.1 없으면 haystack의 마지막 인덱스부터 다시 시작
*/

public class ImplemenStrStr {

  public static void main(String[] args) {
    String haystack = "sadbutsad";
    String needle = "sad";
    ImplemenStrStrSolution solution = new ImplemenStrStrSolution();
    System.out.println(solution.strStr(haystack, needle));
  }
}

class ImplemenStrStrSolution {

  public int strStr(String haystack, String needle) {
    return 0;
  }
}
