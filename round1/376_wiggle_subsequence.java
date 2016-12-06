public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        
        // first difference is positive
        int max = 1;
        for (int i = 0; i < nums.length; i++)
            dp[i] = 1;
        for (int i = 1; i < nums.length; i++) {
            // j = 0
            if (nums[i] > nums[0]) {
                dp[i] = 2;
                max = Math.max(max, 2);
            }
            for (int j = 1; j < i; j++) {
                if (dp[j] % 2 == 0 && nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                } else if (dp[j] % 2 == 1 && nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        // for (int i = 0; i < nums.length; i++)
        //     System.out.println(dp[i]);
        // first difference is negative
        for (int i = 0; i < nums.length; i++)
            dp[i] = 1;
        for (int i = 1; i < nums.length; i++) {
            // j = 0
            if (nums[i] < nums[0]) {
                dp[i] = 2;
                max = Math.max(max, 2);
            }
            for (int j = 1; j < i; j++) {
                if (dp[j] % 2 == 0 && nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                } else if (dp[j] % 2 == 1 && nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}
