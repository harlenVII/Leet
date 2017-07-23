public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null || nums2.length == 0)
            return;
        if (nums1.length == 0) {
            for (int i = 0; i < nums2.length; i++)
                nums1[i] = nums2[i];
            return;
        }
        int p = m + n - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (nums2[n] > nums1[m]) {
                nums1[p--] = nums2[n--];
            } else {
                nums1[p--] = nums1[m--];
            }
        }
        while (n >= 0) {
            nums1[p--] = nums2[n--];
        }
    }
}
