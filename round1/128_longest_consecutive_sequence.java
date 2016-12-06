public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 1;
        for (int num : nums)
            set.add(num);
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int count = 0;
                while (set.contains(num++))
                    count++;
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
