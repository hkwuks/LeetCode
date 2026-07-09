class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        maxPos=0
        for i in range(n-1):
            maxPos = max(maxPos,i+nums[i])
            if maxPos <= i:
                return False

        return True

  class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        maxPos=0
        for i in range(n):
            if maxPos >=i:
                maxPos = max(maxPos,i+nums[i])
                if maxPos >= n-1:
                    return True

        return False
