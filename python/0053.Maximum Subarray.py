class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        pre = 0
        maxans = nums[0]
        for i in nums:
            pre = max(pre + i, i)
            maxans = max(pre, maxans)
        return maxans
