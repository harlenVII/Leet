class Solution {
    public int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            int n = 0;
            for (int num : nums) {
                if (((num >> i) & 1) == 1)
                    n++;
            }
            sum += (nums.length - n) * n;
        }
        return sum;
    }
}
