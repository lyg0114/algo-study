package hackerrank;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author : iyeong-gyo
 * @package : hackerrank
 * @since : 31.01.24
 */
public class SimpleTextEditor {

  private static final Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int cnt = sc.nextInt();
    int cmd = -1;
    String S = "";
    Stack<String> undo = new Stack<>();
    int k;
    for (int i = 0; i < cnt; i++) {
      cmd = sc.nextInt();
      switch (cmd) {
        case 1:
          String inputStr = sc.next();
          undo.push(S);
          S = undo.peek() + inputStr;
          break;
        case 2:
          k = sc.nextInt();
          undo.push(S);
          int size = S.length() - k;
          S = size == 0 ? "" : S.substring(0, size);
          break;
        case 3:
          k = sc.nextInt();
          System.out.println(S.charAt(k - 1));
          break;
        case 4:
          S = undo.pop();
          break;
        default:
      }
    }
  }
}
