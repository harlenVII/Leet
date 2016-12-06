public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int[] dp = new int[s.length() + 1];
        int max = 0;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) == '(')
                continue;
            if (dp[i - 1] == 0) {
                if (s.charAt(i - 2) == '(')
                    dp[i] = 2 + dp[i - 2];
            } else {
                if (i - 2 - dp[i - 1] >= 0 && s.charAt(i - 2 - dp[i - 1]) == '(')
                    dp[i] = dp[i - 1] + 2 + dp[i - 2 - dp[i - 1]];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

// public class Solution {
//     public int longestValidParentheses(String s) {
//         if (s == null || s.length() == 0)
//             return 0;
//         int[] dp = new int[s.length() + 1];
//         dp[0] = dp[1] = 0;
//         int max = 0;
//         for (int i = 2; i <= s.length(); i++) {
//             if (s.charAt(i - 1) == '(')
//                 dp[i] = 0;
//             else if (dp[i - 1] == 0) {
//                 if (s.charAt(i - 2) == '(')
//                     dp[i] = 2 + dp[i - 2];
//                 else
//                     dp[i] = 0;
//             } else {
//                 if (i - 2 - dp[i - 1] >= 0 && s.charAt(i - 2 - dp[i - 1]) == '(')
//                     dp[i] = dp[i - 1] + 2 + dp[i - 2 - dp[i - 1]];
//                 else
//                     dp[i] = 0;
//             }
//             max = Math.max(max, dp[i]);
//         }
//         return max;
//     }
// }
