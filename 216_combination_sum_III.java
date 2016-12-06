public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(k, n, res, new ArrayList<Integer>(), 0, 1);
        return res;
    }
    private void helper(int k, int n, List<List<Integer>> res, List<Integer> cur, int curSum, int index) {
        if (curSum > n || cur.size() > k)
            return;
        if (cur.size() == k && curSum == n) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = index; i < 10; i++) {
            cur.add(i);
            curSum += i;
            helper(k, n, res, cur, curSum, i + 1);
            curSum -= i;
            cur.remove(cur.size() - 1);
        }
    }
}
