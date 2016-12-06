public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null)
            return null;
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1)
            set1.add(num);
        Set<Integer> res = new HashSet<>();
        for (int num : nums2)
            if (set1.contains(num))
                res.add(num);
        int[] result = new int[res.size()];
        int i = 0;
        for (Integer num : res)
            result[i++] = num;
        return result;
    }
}
