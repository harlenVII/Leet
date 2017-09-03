class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int sum = 0;
        int i = 0, j = 0;
        int res = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j++];
            while (sum >= s) {
                res = Math.min(res, j - i);
                sum -= nums[i++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
