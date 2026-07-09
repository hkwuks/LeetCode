class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        maxP = 0
        minPrice = inf
        maxPrice = 0 # 为了剪枝，其实就是trick
        for price in prices:
            if price < minPrice: # 这种方法比min()快
                minPrice = price
                maxPrice = minPrice
            if price > maxPrice:
                maxPrice = price
                maxP = max(maxP, price - minPrice)

        return maxP
