package leetCode.topInterView.searching;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.searching
 * @since : 2023/04/13
 */

class FirstBadVersionSolution {

  public static void main(String[] args) {
    FirstBadVersion version = new FirstBadVersion();
    System.out.println(version.firstBadVersion(3));
  }
}

class VersionControl {

  boolean isBadVersion(int version) {
    if (version >= 2) {
      return true;
    } else {
      return false;
    }
  }
}

public class FirstBadVersion extends VersionControl {
  public int firstBadVersion(int n) {
    int left = 1;
    int right = n;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (isBadVersion(mid)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }
}
