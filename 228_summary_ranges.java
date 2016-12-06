public class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<String>();
        int i = 0;
        int low;
        List<String> result = new ArrayList<String>();
        while (i < nums.length) {
            low = nums[i];
            while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1)
                i++;
            if (nums[i] == low) {
                result.add(String.valueOf(low));
            }
            else {
                result.add(String.valueOf(low) + "->" + String.valueOf(nums[i]));
            }
            i++;
        }
        return result;
    }
}
