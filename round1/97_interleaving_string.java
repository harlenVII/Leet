public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null || s3.length() != s1.length() + s2.length())
            return false;
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++)
            if (s1.substring(0, i).equals(s3.substring(0, i)))
                dp[i][0] = true;
            else
                dp[i][0] = false;
        for (int i = 0; i <= s2.length(); i++)
            if (s2.substring(0, i).equals(s3.substring(0, i)))
                dp[0][i] = true;
            else
                dp[0][i] = false;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);
                char c3 = s3.charAt(i + j - 1);
                if(c1 == c3 && c2 == c3)
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                else if (c1 == c3)
                    dp[i][j] = dp[i - 1][j];
                else if (c2 == c3)
                    dp[i][j] = dp[i][j - 1];
                else
                    dp[i][j] = false;
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
