// public class Solution {
//     public int rob(int[] nums) {
//         if (nums == null || nums.length == 0)
//             return 0;
//         if (nums.length == 1)
//             return nums[0];
//         int[] dp = new int[nums.length]; // dp[i] means the max value of robber ending in i
//         dp[0] = nums[0];
//         dp[1] = nums[1];
//         int max = Math.max(dp[0], dp[1]);
//         for (int i = 2; i < nums.length; i++) {
//             int tempMax = 0;
//             for (int j = 0; j <= i - 2; j++) {
//                 tempMax = Math.max(tempMax, dp[j] + nums[i]);
//             }
//             dp[i] = tempMax;
//             max = Math.max(max, tempMax);
//         }
//         return max;
//     }
// }

public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int[] dp = new int[nums.length]; // dp[i] means the max value of robber from the first i houses
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }
}
