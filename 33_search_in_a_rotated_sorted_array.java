public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int start = 0, end = nums.length - 1;
        while(start + 1 < end){
            int middle = start + (end - start) / 2;
            if (nums[middle] > nums[start]){
                if (target >= nums[start] && target <= nums[middle])
                    end = middle;
                else
                    start = middle;
            }else{
                if (target <= nums[end] && target >= nums[middle])
                    start = middle;
                else
                    end = middle;
            }
        }
        if (nums[start] == target)
            return start;
        if (nums[end] == target)
            return end;
        return -1;
    }
}
