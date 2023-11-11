package codility;

/**
 * @author : iyeong-gyo
 * @package : codility
 * @since : 11.11.23
 */
public class CodilitySolution1_1 {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();

    int AA = 10;
    int AB = 10;
    int BB = 10;
    String longestStr = solution(AA, AB, BB);

    long endTime = System.currentTimeMillis();
    long elapsedTime = endTime - startTime;

    System.out.println("longestStr = " + longestStr);
    System.out.println("실행 시간: " + elapsedTime + " 밀리초");
  }

  private static String solution(int AA, int AB, int BB) {
    StringBuilder result = new StringBuilder();
    while (AA > 0 && BB > 0) {
      result.append("AB");
      AA--;
      BB--;
    }

    while (AA > 0) {
      result.append("AA");
      AA--;
    }

    while (BB > 0) {
      result.append("BB");
      BB--;
    }
    return result.toString();
  }
}
