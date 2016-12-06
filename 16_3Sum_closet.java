public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length <= 2)
            return -1;
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                result = Math.abs(target - sum) < Math.abs(target - result) ? sum : result;
                if (target == sum)
                    return target;
                else if (target > sum)
                    j++;
                else
                    k--;
            }
        }
        return result;
    }
}
