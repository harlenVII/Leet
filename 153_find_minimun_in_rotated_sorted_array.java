public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        
        int start = 0, end = nums.length - 1;
        
        //didn't rotate
        if (nums[start] < nums[end])
            return nums[start];
        
        while(start + 1 < end){
            int middle = start + (end - start) / 2;
            if (nums[middle] > nums[start])
                start = middle;
            else
                end = middle;
        }
        return Math.min(nums[start], nums[end]);
    }
}
