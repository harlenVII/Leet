public class Solution {
    public int trailingZeroes(int n) {
        if (n < 0)
            return -1;
        int res = 0;
        while (n != 0) {
            n /= 5;
            res += n;
        }
        return res;
    }
}
