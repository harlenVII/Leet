public class Solution {
    int result = 0;
    public int totalNQueens(int n) {
        if (n <= 0)
            return 0;
        helper(n, new ArrayList<>());
        return result;
    }
    private void helper(int n, List<Integer> cur) {
        if (cur.size() == n) {
            result++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(cur, i)) {
                cur.add(i);
                helper(n, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
    private boolean isValid(List<Integer> cur, int num) {
        int size = cur.size();
        for (int i = 0; i < size; i++) {
            if (num == cur.get(i))
                return false;
            if (cur.get(i) - num == size - i)
                return false;
            if (num - cur.get(i) == size - i)
                return false;
        }
        return true;
    }
}
