public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0 || target <= 0)
            return result;
        Arrays.sort(candidates);
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
            if (i != index && can[i] == can[i - 1])
                continue;
            cur.add(can[i]);
            thisSum += can[i];
            helper(result, can, target, cur, thisSum, i + 1);
            cur.remove(cur.size() - 1);
            thisSum -= can[i];
        }
    }
}
