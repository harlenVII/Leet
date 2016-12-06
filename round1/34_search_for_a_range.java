public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return null;
        return new int[]{searchLeft(nums, target), searchRight(nums, target)};
    }
    public int searchLeft(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int start = 0, end = nums.length - 1;
        while (start + 1 < end){
            int middle = start + (end - start) / 2;
            if (nums[middle] >= target)
                end = middle;
            else
                start = middle;
        }
        if (nums[start] == target)
            return start;
        else if (nums[end] == target)
            return end;
        return -1;
    }
    public int searchRight(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int start = 0, end = nums.length - 1;
        while (start + 1 < end){
            int middle = start + (end - start) / 2;
            if (nums[middle] > target)
                end = middle;
            else
                start = middle;
        }
        if (nums[end] == target)
            return end;
        else if (nums[start] == target)
            return start;
        return -1;
    }
}
