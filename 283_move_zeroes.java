public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int p0 = 0;
        for (int cur = 0; cur < nums.length; cur++) {
            if (nums[cur] != 0) {
                nums[p0++] = nums[cur];
            }
        }
        while (p0 < nums.length)
            nums[p0++] = 0;
    }

