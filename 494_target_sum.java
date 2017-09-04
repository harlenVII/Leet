class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int[][] memo = new int[nums.length + 1][2001];
        for (int[] i : memo)
            Arrays.fill(i, -1);
        return helper(nums, 0, S, 0, memo);
    }
    
    private int helper(int[] nums, int index, int S, int sum, int[][] memo) {
        if (memo[index][sum+1000] != -1)
            return memo[index][sum+1000];
        if (index == nums.length) {
            if (sum == S) return 1;
            else return 0;
        }
        int count = helper(nums, index + 1, S, sum + nums[index], memo) + helper(nums, index + 1, S, sum - nums[index], memo);
        memo[index][sum+1000] = count;
        return count;
    }
}
