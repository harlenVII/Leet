public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n < 1)
            return result;
        helper(result, n, new ArrayList<>());
        return result;
    }
    private void helper(List<List<String>> result, int n, List<Integer> cur) {
        if (cur.size() == n) {
            result.add(draw(cur));
            return;
        }
        for (int i = 0; i < n; i++) {
            if(isValid(cur, i)) {
                cur.add(i);
                helper(result, n, cur);
                cur.remove(cur.size() -1);
            }
        }
    }
    private List<String> draw(List<Integer> cur) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < cur.size(); i++) {
            String s = "";
            for (int j = 0; j < cur.size(); j++) {
                if (cur.get(i) == j)
                    s += 'Q';
                else
                    s += '.';
            }
            result.add(s);
        }
        return result;
    }
    private boolean isValid(List<Integer> list, int num) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i) == num)
                return false;
            if (list.get(i) - num == size - i)
                return false;
            if (num - list.get(i) == size - i)
                return false;
        }
        return true;
    }
}
