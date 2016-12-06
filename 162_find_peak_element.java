public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int start = 0, end = nums.length - 1;
        while(start <= end){
            int middle = start + (end - start) / 2;
            
            //make them long to sure the minimum value is less than Integer.MIN_VALUE
            long leftValue = middle == 0 ? Long.MIN_VALUE : nums[middle - 1];
            long rightValue = middle == nums.length - 1 ? Long.MIN_VALUE : nums[middle + 1];
            
            if (nums[middle] > leftValue && nums[middle] > rightValue)
                return middle;
            else if (nums[middle] > leftValue && nums[middle] < rightValue)
                start = middle + 1;
            else
                end = middle - 1;
        }
        return -1;
    }
}
