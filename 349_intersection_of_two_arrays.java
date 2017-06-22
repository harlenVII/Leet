public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null)
            return null;
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1)
            set1.add(num);
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2)
            if (set1.contains(num))
                set2.add(num);
        return set2.stream().mapToInt(i->i).toArray();
    }
}`
