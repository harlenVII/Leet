public class Solution {
    public int lengthOfLIS(int[] nums) {
        int longestLength = 0;
        int[] dp = new int[nums.length];//dp[i] stores the LIS of the subsequence which is from nums[0] to nums[i] including the nums[i]
        for (int i = 0; i< dp.length; i++)
            dp[i] = 1;
        for (int i = 0; i < nums.length; i++){//find dp[i]
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j] && dp[j] + 1 > dp[i]){//dp[i] = max{dp[j] + 1} where 0 <= j < i and nums[i] > nums[j]
                    dp[i] = dp[j] + 1;
                }
            }
            longestLength = Math.max(longestLength, dp[i]);
        }
        return longestLength;
    }
}
