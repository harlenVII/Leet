public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int ptr1 = 0, ptr2 = 0, minLen = Integer.MAX_VALUE, sum = 0;
        while (ptr1 < nums.length){
            if (sum < s){
                if (ptr2 < nums.length){
                    sum += nums[ptr2++];
                }else{
                    break;
                }
            }else{
                minLen = Math.min(minLen, ptr2 - ptr1);
                sum -= nums[ptr1++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
