class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) return 0;
        int profit0 = 0;
        int profit1 = -prices[0] - fee;
        int newProfit0, newProfit1;
        for (int i = 1; i < prices.length; i++) {
            newProfit0 = Math.max(profit0, profit1 + prices[i]);
            newProfit1 = Math.max(profit1, profit0 - prices[i] - fee);
            profit0 = newProfit0;
            profit1 = newProfit1;
        }
        return profit0;
    }
}