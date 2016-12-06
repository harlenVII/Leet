// public class Solution {
//     public int numSquares(int n) {
//         int[] dp = new int[n + 1];
//         dp[1] = 1;
//         int square = 2;
//         for (int i = 2; i <= n; i++) {
//             if (i == Math.pow(square, 2)) {
//                 dp[i] = 1;
//                 square++;
//                 continue;
//             }
//             int min = Integer.MAX_VALUE;
//             for (int j = 1; j <= i / 2; j++) {
//                 min = Math.min(min, dp[j] + dp[ i - j]);
//             }
//             dp[i] = min;
//         }
//         return dp[n];
//     }
// }
public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, 1 + dp[i - j*j]);
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
