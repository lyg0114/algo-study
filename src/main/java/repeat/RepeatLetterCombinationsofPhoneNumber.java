package repeat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import leetCode.topInterView.Strings.LetterCombinationsofPhoneNumber.LetterCombinationsofPhoneNumberInterface;

/**
 * @author : iyeong-gyo
 * @package : repeat
 * @since : 2023/05/28
 */
public class RepeatLetterCombinationsofPhoneNumber implements
    LetterCombinationsofPhoneNumberInterface {

  private final Map<Character, String> pnm = new HashMap<>() {{
    put('2', "abc");
    put('3', "def");
    put('4', "ghi");
    put('5', "jkl");
    put('6', "mno");
    put('7', "pqrs");
    put('8', "tuv");
    put('9', "wxyz");
  }};

  @Override
  public List<String> letterCombinations(String digits) {
    List<String> results = new ArrayList<>();
    backtrack(digits, 0, new StringBuilder(), results);
    return results;
  }

  private void backtrack(String digits, int index, StringBuilder sb, List<String> results) {
    if (index == digits.length()) {
      results.add(sb.toString());
      return;
    }

    char digit = digits.charAt(index);
    String letters = pnm.get(digit);
    for (char letter : letters.toCharArray()) {
      sb.append(letter);
      backtrack(digits, index + 1, sb, results);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
