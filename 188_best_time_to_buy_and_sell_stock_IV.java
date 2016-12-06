public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k <= 0)
            return 0;
            
        if (k >= prices.length / 2) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++)
                profit += prices[i] > prices[i - 1] ? prices[i] - prices[i - 1] : 0;
            return profit;
        }
        
        int[] sell = new int[k + 1];
        int[] buy = new int[k + 1];
        for (int i = 0; i < buy.length; i++)
            buy[i] = Integer.MIN_VALUE;
        for (int price : prices) {
            for (int i = 1; i < buy.length; i++) {
                buy[i] = Math.max(buy[i], sell[i - 1] - price);
                sell[i] = Math.max(sell[i], buy[i] + price);
            }
        }
        return sell[k];
    }
}
