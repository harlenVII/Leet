class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        int res = 1;
        for (int num : nums) {
            if (set.remove(num)) {
                int count = 1;
                int i = 1;
                while (set.contains(num - i)) {
                    set.remove(num - i);
                    count++;
                    i++;
                }
                i = 1;
                while (set.contains(num + i)) {
                    set.remove(num + i);
                    count++;
                    i++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
