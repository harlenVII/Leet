public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        Arrays.sort(nums);
        helper(result, nums, 0, new ArrayList<Integer>());
        return result;
    }
    private void helper(List<List<Integer>> result, int[] nums, int index, List<Integer> cur) {
        result.add(new ArrayList<Integer>(cur));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1])
                continue;
            cur.add(nums[i]);
            helper(result, nums, i + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
