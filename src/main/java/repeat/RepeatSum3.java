package repeat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import leetCode.topInterView.others.Sum3.Sum3Interface;

/**
 * @author : iyeong-gyo
 * @package : repeat
 * @since : 2023/05/28
 */
public class RepeatSum3 implements Sum3Interface {

  @Override
  public List<List<Integer>> threeSum(int[] nums) {
    int taret = 0;
    Arrays.sort(nums);
    Set<List<Integer>> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      int j = i + 1;
      int k = nums.length - 1;
      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (sum == taret) {
          set.add(Arrays.asList(nums[i], nums[j], nums[k]));
          j++;
          k--;
        } else if (sum < taret) {
          j++;
        } else {
          k--;
        }
      }
    }
    return new ArrayList<>(set);
  }
}
