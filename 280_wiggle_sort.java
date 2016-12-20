public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i - 1];
            if ((i % 2 == 1) == (num > nums[i])) {
                nums[i - 1] = nums[i];
                nums[i] = num;
            }
        }
    }
}
