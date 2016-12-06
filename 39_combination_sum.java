public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return result;
        helper(result, candidates, target, new ArrayList<Integer>(), 0, 0);
        return result;
    }
    private void helper(List<List<Integer>> result, int[] can, int target, List<Integer> cur, int thisSum, int index) {
        if (thisSum == target) {
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        if (thisSum > target)
            return;
        for (int i = index; i < can.length; i++) {
            cur.add(can[i]);
            thisSum += can[i];
            helper(result, can, target, cur, thisSum, i);
            cur.remove(cur.size() - 1);
            thisSum -= can[i];
        }
    }
}
