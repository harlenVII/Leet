class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 2)
            return false;
        if (k == 0) {
            // check if continuous 0
            boolean last0 = nums[0] == 0;
            for (int i = 1; i < nums.length; i++) {
                boolean this0 = nums[i] == 0;
                if (this0 && last0)
                    return true;
                last0 = this0;
            }
            return false;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum % k == 0)
                    return true;
            }
        }
        return false;
    }
}
