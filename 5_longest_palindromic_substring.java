public class Solution {
    public String longestPalindrome(String s) {
        if (s == null)
            return null;
        if (s.length() <= 1)
            return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 1, start = 0, end = 0;
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
