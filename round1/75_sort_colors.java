public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int left = 0, right = nums.length - 1;
        for (int i = left; i <= right; i++) {
            if (nums[i] == 2) {
                int temp = nums[right];
                nums[right] = nums[i];
                nums[i] = temp;
                right--;
                i--; // don't know which nums[right] is
            }else if (nums[i] == 0) {
                int temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
                left++;
                //i--; left is small than i, so it is 1
            }
        }
    }
}
