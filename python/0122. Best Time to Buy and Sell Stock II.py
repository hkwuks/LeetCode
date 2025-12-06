class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        maxP = 0
        for i in range(1,n):
            maxP = max(maxP,maxP+prices[i]-prices[i-1])
        return maxP
