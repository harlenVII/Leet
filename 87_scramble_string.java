public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length())
            return false;
        int len = s1.length();
        boolean[][][] dp = new boolean[len][len][len + 1];
        for (int k = 1; k <= len; k++) {
            for (int i = 0; i + k <= len; i++) {
                for (int j = 0; j + k <= len; j++) {
                    if (k == 1)
                        dp[i][j][k] = s1.charAt(i) == s2.charAt(j) ? true : false;
                    for (int l = 1; l < k; l++) {
                        dp[i][j][k] = dp[i][j][l] && dp[i + l][j + l][k - l] || dp[i][j + k - l][l] && dp[i + l][j][k - l];
                        if (dp[i][j][k])
                            break;
                    }
                }
            }
        }
        return dp[0][0][len];
    }
}
