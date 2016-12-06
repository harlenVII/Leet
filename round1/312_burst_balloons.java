public class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] numbers = new int[nums.length + 2];
        for (int i = 0 ; i < nums.length; i++) {
            numbers[i + 1] = nums[i];
        }
        numbers[0] = numbers[nums.length + 1] = 1;
        int dp[][] = new int[numbers.length][numbers.length];
        
        for (int len = 1; len <= nums.length; len++) {
            for (int start = 1; start + len < numbers.length; start++) {
                int end = start + len - 1;
                for (int i = start; i <= end; i++) {
                    dp[start][end] = Math.max(dp[start][end], numbers[start - 1] * numbers[i] * numbers[end + 1] + dp[start][i - 1] + dp[i + 1][end]);
                }
            }
        }
        return dp[1][nums.length];
    }
}
