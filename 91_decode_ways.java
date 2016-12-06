public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int[] dp = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                if (s.charAt(0) == '0')
                    return 0;
                else
                    dp[0] = 1;
            }else if (i == 1) {
                dp[1] = s.charAt(1) == '0' ? 0 : 1;
                if (Integer.parseInt(s.substring(i - 1, i + 1)) <= 26)
                    dp[1]++;
            }else {
                int sub = Integer.parseInt(s.substring(i - 1, i + 1));
                if (s.charAt(i) == '0') {
                    if (sub == 10 || sub == 20)
                        dp[i] = dp[i - 2];
                    else
                        return 0;
                }else {
                    dp[i] = dp[i - 1] + (sub <= 26 && sub > 10 ? dp[i - 2] : 0);
                }
            }
        }
        return dp[s.length() - 1];
    }
}
