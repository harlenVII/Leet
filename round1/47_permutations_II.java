public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null)
            return res;
        Arrays.sort(nums);
        helper(res, nums, new ArrayList<Integer>(), new boolean[nums.length]);
        return res;
    }
    private void helper(List<List<Integer>> res, int[] nums, List<Integer> cur, boolean[] used) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]))
                continue;
            cur.add(nums[i]);
            used[i] = true;
            helper(res, nums, cur, used);
            used[i] = false;
            cur.remove(cur.size() - 1);
        }   
    }
}
