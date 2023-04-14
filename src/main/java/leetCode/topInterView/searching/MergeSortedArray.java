package leetCode.topInterView.searching;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.searching
 * @since : 2023/04/14
 */
public class MergeSortedArray {

  public static void main(String[] args) {
    int nums1[] = {1, 2, 3, 0, 0, 0};
    int nums2[] = {2, 5, 6};
    MergeSortedArrayInterface solution = new MergeSortedArraySolution();
    solution.merge(nums1, 3, nums2, 3);
    for (int i = 0; i < nums1.length; i++) {
      System.out.println("nums1[i] : " + nums1[i]);
    }
  }
}

class MergeSortedArraySolution implements MergeSortedArrayInterface {
  @Override
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1; // nums1에서 사용할 인덱스
    int j = n - 1; // nums2에서 사용할 인덱스
    int k = m + n - 1; // nums1에서 결과를 저장할 위치

    // 두 배열 중 큰 값을 nums1 뒤에서부터 저장하면서 병합
    while (i >= 0 && j >= 0) {
      if (nums1[i] >= nums2[j]) {
        nums1[k--] = nums1[i--];
      } else {
        nums1[k--] = nums2[j--];
      }
    }

    // nums2의 나머지 값이 있다면 nums1 앞부분에 저장
    while (j >= 0) {
      nums1[k--] = nums2[j--];
    }
  }
}

interface MergeSortedArrayInterface {
  void merge(int[] nums1, int m, int[] nums2, int n);
}
