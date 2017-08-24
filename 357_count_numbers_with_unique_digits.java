public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n <= 0)
            return 1;
        int dp[] = new int[11];
        dp[1] = 10;
        for (int i = 2; i <= n; i++) {
            int factor = 9;
            int temp = 9;
            for (int j = i - 1; j > 0; j--) {
                temp *= factor--;
            }
            dp[i] = temp + dp[i - 1];
        }
        return dp[n];
    }
}
