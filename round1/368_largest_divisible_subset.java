public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        if (nums.length == 1) {
            res.add(nums[0]);
            return res;
        }
        Arrays.sort(nums);
        int[] count = new int[nums.length];
        int[] parent = new int[nums.length];
        int max = 0, maxIndex = 0;
        for (int i = nums.length - 1; i >= 0; i--) { // compute count[i]
            for (int j = i; j < nums.length; j++) {
                if (nums[j] % nums[i] == 0 && count[i] < count[j] + 1) {
                    count[i] = count[j] + 1;
                    parent[i] = j;
                    if (count[i] > max) {
                        max = count[i];
                        maxIndex = i;
                    }
                }
            }
        }
        for (int i = 0; i < max; i++) {
            res.add(nums[maxIndex]);
            maxIndex = parent[maxIndex];
        }
        return res;
    }
}
