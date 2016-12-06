public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++)
            dp[i][0] = false;
        for (int j = 1; j <= n; j++)
            if (p.charAt(j - 1) == '*' && dp[0][j - 2])
                dp[0][j] = true;
            else
                dp[0][j] = false;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char cs = s.charAt(i - 1);
                char cp = p.charAt(j - 1);
                if (cs == cp || cp == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (cp == '*') {
                    char cpre = p.charAt(j - 2);
                    if (cpre != '.' && cpre != cs)
                        dp[i][j] = dp[i][j - 2];
                    else
                        dp[i][j] = dp[i][j - 1] || dp[i][j - 2] || dp[i - 1][j];
                } else
                    dp[i][j] = false;
            }
        }
        return dp[m][n];
    }
}
