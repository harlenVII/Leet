// public class Solution {
//     public int coinChange(int[] coins, int amount) {
//         if (coins == null || coins.length == 0 || amount == 0)
//             return 0;
//         int[] dp = new int [amount + 1];
        
//         dp[1] = -1;
//         for (int coin: coins)
//             if (coin < amount)
//                 dp[coin] = 1;
                
//         for (int i = 2; i <= amount; i++) {
//             if (dp[i] == 1)
//                 continue;
//             int min = Integer.MAX_VALUE;
//             for (int j = 1; j <= i / 2; j++) {
//                 if (dp[j] == -1 || dp[i - j] == -1)
//                     continue;
//                 min = Math.min(min, dp[j] + dp[i - j]);
//             }
//             dp[i] = min == Integer.MAX_VALUE ? -1 : min;
//         }
//         return dp[amount];
//     }
// }

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount == 0)
            return 0;
        int[] dp = new int [amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
