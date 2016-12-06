public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0)
            return res;
        helper(n, n, res, new String());
        return res;
    }
    private void helper(int left, int right, List<String> res, String cur) {
        if (left == 0 && right == 0) {
            res.add(cur);
            return;
        }
        if (left != 0)
            helper(left - 1, right, res, cur + "(");
        if (left < right || left == 0)
            helper(left, right - 1, res, cur + ")");
    }
}
