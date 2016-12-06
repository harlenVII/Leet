public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4)
            return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            if ((nums[i] << 2) > target)
                break;
            for (int j = nums.length - 1; j > i + 2; j--) {
                if (j < nums.length - 1 && nums[j] == nums[j + 1])
                    continue;
                if ((nums[j] << 2) < target)
                    break;
                int m = i + 1;
                int n = j - 1;
                while (m < n) {
                    int sum = nums[i] + nums[j] + nums[m] + nums[n];
                    if (sum < target)
                        m++;
                    else if (sum > target)
                        n--;
                    else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));
                        while (nums[m] == nums[++m] && m < n);
                        while (nums[n] == nums[--n] && m < n);
                    }
                }
            }
        }
        return result;
    }
}
