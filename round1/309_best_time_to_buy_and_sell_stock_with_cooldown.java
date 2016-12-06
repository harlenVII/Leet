// public class Solution {
//     public int maxProfit(int[] prices) {
//         if (prices == null || prices.length < 2)
//             return 0;
//         int[] buy = new int[prices.length];
//         int[] sell = new int[prices.length];
//         buy[0] = -prices[0];
//         int max = 0;
//         for (int i = 1; i < prices.length; i++) {
//             sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1] - prices[i - 1] + prices[i]);
//             buy[i] = i == 1 ? - prices[1] : Math.max(sell[i - 2] - prices[i], buy[i - 1] + prices[i - 1] - prices[i]);
//             max = Math.max(sell[i], max);
//         }
//         return max;
//     }
// }

public int maxProfit(int[] prices) {
    if (prices == null || prices.length <= 1) {
        return 0;
    }
    
    int[] buy = new int[prices.length + 1];
    buy[1] = -prices[0];
    
    int[] sell = new int[prices.length + 1];
    
    for (int i = 2; i <= prices.length; i++) {
        buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i - 1]);
        sell[i] = Math.max(sell[i - 1], prices[i - 1] + buy[i - 1]);
    }
    
    return sell[prices.length];
}


