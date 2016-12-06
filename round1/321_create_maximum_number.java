public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums2 == null || nums1.length + nums2.length < k)
            return null;
        int[] result = new int[k];
        int numsFromNums1 = Math.min(k, nums1.length);
        for (int i = Math.max(k - nums2.length, 0); i <= numsFromNums1; ++i) {
            int[] n1 = getMaxMNumbers(nums1, i);
            int[] n2 = getMaxMNumbers(nums2, k - i);
            int[] thisRes = merge(n1, n2);

            if (isGreater(result, 0, thisRes, 0) == false) {
                result = thisRes;
            }
        }
        return result;
    }
    private int[] getMaxMNumbers(int[] nums, int m) {
        int[] res = new int[m];
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            while (pos > 0 && pos + nums.length - i > m && nums[i] > res[pos - 1]) {
                pos--;
            }
            if (pos < m)
                res[pos++] = nums[i];
        }
        return res;
    }
    private int[] merge(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        int i = 0, j = 0, pos = 0;
        while (i < nums1.length && j < nums2.length) {
            if (isGreater(nums1, i, nums2, j))
                res[pos++] = nums1[i++];
            else
                res[pos++] = nums2[j++];
        }
        while (i < nums1.length)
            res[pos++] = nums1[i++];
        while (j < nums2.length)
            res[pos++] = nums2[j++];
        return res;
    }
    private boolean isGreater(int[] nums1, int s1, int[] nums2, int s2) {
        int i = s1, j = s2;
        for (; i < nums1.length && j < nums2.length; i++, j++)
            if (nums1[i] > nums2[j])
                return true;
            else if (nums1[i] < nums2[j])
                return false;
        return i != nums1.length;
    }
}
