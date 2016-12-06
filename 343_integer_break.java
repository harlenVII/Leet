public class Solution {
    public int integerBreak(int n) {
        int[] nums = new int[Math.max(n + 1, 5)];
        nums[2] = 1;
        nums[3] = 2;
        nums[4] = 4;
        for (int i = 5; i <= n; i++) {
            int max = 0;
            for (int j = 2; j <= i / 2; j++)
                max = Math.max(max, Math.max(j, nums[j]) * Math.max(i - j, nums[i - j]));
            nums[i] = max;
        }
        return nums[n];
    }
}
