public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int start = 0, end = nums.length - 1;
        while (start + 1 < end){
            int middle = start + (end - start) / 2;
            if (nums[middle] >= target){
                end = middle;
            }else{
                start = middle;
            }
        }
        if (nums[start] >= target){
            return start;
        }
        if (nums[end] >= target)
            return end;
        return end + 1;
    }
}
