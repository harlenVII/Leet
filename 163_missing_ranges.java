public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums == null)
            return res;
        int start = 0;
        int end = 0;
        if (nums.length == 0) {
            start = lower;
            end = upper;
            if (start == end) 
                res.add(String.valueOf(start));
            else
                res.add(String.valueOf(start) + "->" + String.valueOf(end));
            return res;
        }
        if (lower < nums[0]) {
            start = lower;
            end = nums[0] - 1;
            if (start == end) 
                res.add(String.valueOf(start));
            else
                res.add(String.valueOf(start) + "->" + String.valueOf(end));
        }
        int i = 0;
        while (i + 1 < nums.length) {
            // find range
            while (i + 1 < nums.length && nums[i + 1] <= nums[i] + 1) { // could have equal numbers
                i++;
            }
            if (i + 1 == nums.length)
                break;
            start = nums[i] + 1;
            end = nums[i + 1] - 1;
            if (start == end) 
                res.add(String.valueOf(start));
            else
                res.add(String.valueOf(start) + "->" + String.valueOf(end));
            i++;
        }
        if (nums[nums.length - 1] < upper) {
            start = nums[nums.length - 1] + 1;
            end = upper;
            if (start == end) 
                res.add(String.valueOf(start));
            else
                res.add(String.valueOf(start) + "->" + String.valueOf(end));
        }
        return res;
    }
}
