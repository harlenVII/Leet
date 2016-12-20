public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3)
            return 0;
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 3; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                if (nums[i] + nums[start] + nums[end] < target) {
                    res += end - start;
                    start++;
                } else {
                    end--;
                }
            }
        }
        return res;
    }
}
