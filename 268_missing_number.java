public class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null)
            return -1;
        int sum = 0, i = 0;
        for (; i < nums.length; i++)
            sum += i - nums[i];
        return sum + i;
        //the sum from(0-n) - nums[]
    }
}
