public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2)
            return;
        for (int i = nums.length - 2; i >=0; i--) {
            if (nums[i] >= nums[i + 1])
                continue;
            int j;
            for (j = i + 1; j < nums.length; j++)
                if (nums[j] <= nums[i])
                    break;
            int target = j - 1;
            int temp = nums[target];
            nums[target] = nums[i];
            nums[i] = temp;
            Arrays.sort(nums, i + 1, nums.length);
            return;
        }
        Arrays.sort(nums);
    }
}
