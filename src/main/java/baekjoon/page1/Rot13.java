package baekjoon.page1;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.page1
 * @since : 2022/11/08
 * total Alpabet Count : 26
 * A : 65 , Z : 90
 * a : 97 , z : 122
 */
public class Rot13 {
  public static void main(String[] args) {
    Rot13 rot13 = new Rot13();
    String targetStr = "Baekjoon Online Judge";
    char[] chars = targetStr.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      rot13.encryptChar(chars, i);
    }
    for (char aChar : chars) {
      System.out.print(aChar);
    }
  }

  private void encryptChar(char[] chars , int i) {
    char s = chars[i];
    if(s > 97 && s < 122){
      if((s + 13) > 122){
        chars[i] = (char)(97 + ((s + 12)%122));
      } else {
        chars[i] = (char)(s + 13);
      }
    }
    if(s > 65 && s < 90){
      if((s + 13) > 90){
        chars[i] = (char)(65 + ((s + 12)%90));
      } else {
        chars[i] = (char)(s + 13);
      }
    }
  }
}
