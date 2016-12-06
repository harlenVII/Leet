public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        helper(result, nums, new ArrayList<Integer>());
        return result;
    }
    void helper(List<List<Integer>> result, int[] nums, List<Integer> cur) {
        if (cur.size() == nums.length) {
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int num : nums) {
            if (!cur.contains(num)) {
                cur.add(num);
                helper(result, nums, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
