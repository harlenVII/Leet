public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = false;
        }
        for (int j = 1;j <= n; j++) {
            if (p.charAt(j - 1) == '*' && dp[0][j - 1])
                dp[0][j] = true;
            else
                dp[0][j] = false;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1;j <= n; j++) {
                char chs = s.charAt(i - 1);
                char chp = p.charAt(j - 1);
                if (chs == chp || chp == '?')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (chp == '*') {
                    // below is my solution
                    // dp[i][j] = false;
                    // for (int k = 0; k <= i; k++)
                    //     if (dp[k][j - 1] == true) {
                    //         dp[i][j] = true;
                    //         break;
                    //     }
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }else
                    dp[i][j] = false;
            }
        }
        return dp[m][n];
    }
}
