// 动态规划
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int sell = 0;
        int buy = -prices[0];
        for (int i = 1; i < n; ++i) {
            sell = Math.max(sell, buy + prices[i] - fee); // 卖出后余额
            buy = Math.max(buy, sell - prices[i]); // 买入后余额
        }
        return sell;
    }
}

// 贪心算法
class Solution {
    public int maxProfit(int[] prices,int fee) {
        int n = prices.length;
        int buy = prices[0] + fee;
        int profit = 0;
        for (int i = 1; i < n; ++i) {
            if (prices[i] + fee < buy) {
                buy = prices[i] + fee; // 如果决定再次进行交易，就将手续费计入成本
            } else if (prices[i] > buy) {
                profit += prices[i] - buy;
                buy = prices[i]; // 将目前的可卖出价格和后面的价格进行比较
            }
        }
        return profit;
    }
}