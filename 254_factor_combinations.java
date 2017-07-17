public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < 0)
            return res;
        helper(res, new ArrayList<>(), n, 2);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> cur, int n, int start) {
        if (n == 1) {
            if (cur.size() > 1)
                res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                cur.add(i);
                helper(res, cur, n / i, i);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
