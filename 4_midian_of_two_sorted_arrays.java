public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length + nums2.length == 0)
            return -1;//don't know what to return...
        int m = nums1.length;
        int n = nums2.length;
        if ((m + n) % 2 == 0)
            return (findKthElement(nums1, nums2, 0, 0, (m + n) / 2 + 1) + findKthElement(nums1, nums2, 0, 0, (m + n) / 2)) / 2.0;
        else
            return findKthElement(nums1, nums2, 0, 0, (m + n) / 2 + 1);
    }
    // two arrays start from m, n
    // recursively shorten the arrays until k=1, compare the first elements.
    public int findKthElement(int[] nums1, int[] nums2, int m, int n, int k){
        if (m == nums1.length)
            return nums2[n + k - 1];
        if (n == nums2.length)
            return nums1[m + k - 1];
        if (k == 1){
            return Math.min(nums1[m], nums2[n]);
        }
        int halfK = k / 2;
        
        //if one of the arrays does not long enough, just make it big enough, and shorten the other array
        int num1 = m + halfK - 1 < nums1.length ? nums1[m + halfK - 1] : Integer.MAX_VALUE;
        int num2 = n + halfK - 1 < nums2.length ? nums2[n + halfK - 1] : Integer.MAX_VALUE;
        if (num1 < num2)
            return findKthElement(nums1, nums2, m + halfK, n, k - k / 2);
        else
            return findKthElement(nums1, nums2, m, n + halfK, k - k / 2);
    }
}
