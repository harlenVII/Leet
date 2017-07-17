public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if (n < 0)
            return res;
        res.add(0);
        for (int i = 1; i <= n; i++) {
            int size = res.size();
            for (int j = size - 1; j >= 0; j--) {
                res.add(res.get(j) | (1 << (i-1)));
            }
        }
        return res;
    }
}
