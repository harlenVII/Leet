public class Solution {
    public int minCut(String s) {
        if (s == null)
            return -1;
        int len = s.length();
        int[] dp = new int[len];
        boolean[][] pal = new boolean[len][len];
        for (int i = 1; i < len; i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (j + 1 >= i - 1 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, dp[j - 1] + 1);
                }
            }
            dp[i] = min;
        }
        return dp[len - 1];
    }
}
