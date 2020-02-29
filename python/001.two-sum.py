class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        n=len(nums)
        if n<2:
            return None
        map={}
        for i,n in enumerate(nums):
            if target-n in map:
                return [i,map[target-n]]
            else:
                map[n]=i