class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map={}
        for i,n in enumerate(nums):
            if target-n in map:
                return [i,map[target-n]]
            map[n]=i