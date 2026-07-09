class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        n = len(nums)
        len_ = inf
        total = 0
        
        start,end=0,0
        while end<n:
            total+=nums[end]
            while total>=target:
                len_ = min(len_,end-start+1)
                total-=nums[start]
                start+=1
            end+=1
        return 0 if len_==inf else len_
