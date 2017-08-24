public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return true;
            if (nums[left] < nums[mid]) {
                if (nums[left] <= target && nums[mid] > target)
                    right = mid;
                else
                    left = mid;
            } else if (nums[left] > nums[mid]) {
                if (nums[left] > target && nums[mid] < target)
                    left = mid;
                else
                    right = mid;
            } else
                left++;
        }
        return nums[left] == target || nums[right] == target ? true : false;
    }
}
