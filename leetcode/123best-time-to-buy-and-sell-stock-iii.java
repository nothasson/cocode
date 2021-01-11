//https://leetcode-cn.com/circle/article/qiAgHn/ 这篇文章不错
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int profit10 = 0, profit11 = -prices[0], profit20 = 0, profit21 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            profit20 = Math.max(profit20, profit21 + prices[i]);
            profit21 = Math.max(profit21, profit10 - prices[i]);
            profit10 = Math.max(profit10, profit11 + prices[i]);
            profit11 = Math.max(profit11, -prices[i]);
        }
        return profit20;
    }
}