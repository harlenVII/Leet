public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        helper(result, nums, new ArrayList<Integer>(), 0);
        return result;
    }
    private void helper(List<List<Integer>> result, int[] nums, List<Integer> cur, int index) {
        result.add(new ArrayList<Integer>(cur));
        for (int i = index; i < nums.length; i++) {
            cur.add(nums[i]);
            helper(result, nums, cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
    
}
