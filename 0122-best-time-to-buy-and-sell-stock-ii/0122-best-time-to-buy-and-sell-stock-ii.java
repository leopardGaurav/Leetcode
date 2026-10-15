class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        
        // Traverse the prices array starting from the second day
        for (int i = 1; i < prices.length; i++) {
            // If today's price is greater than yesterday's, capture the profit
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        
        return maxProfit;
    }
}