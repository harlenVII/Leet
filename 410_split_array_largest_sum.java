class Solution {
    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0)
            return 0;
        long sum = 0;
        int max= 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        if (m == 1)
            return (int)sum;
        long i = max, j = sum;
        while (i + 1 < j) {
            long mid = (i + j) / 2;
            if (isValid(nums, m, mid))
                j = mid;
            else
                i = mid;
        }
        if (isValid(nums, m, i))
            return (int)i;
        return (int)j;
    }
    
    private boolean isValid(int[] nums, int m, long target) {
        long sum = 0;
        int count = 1;
        for (int num : nums) {
            sum += num;
            if (sum > target) {
                sum = num;
                count++;
                if (count > m) return false;
            }
        }
        return true;
    }
}
