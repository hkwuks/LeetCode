class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        n = len(nums)
        ans = []

        for first in range(n):
            if nums[first] > 0:
                break
            if first>0 and nums[first] ==nums[first-1]:
                continue
            
            third = n-1
            target = -nums[first]

            second=first+1
            while second<third:
                if nums[second]+nums[third]<target:
                    second+=1
                elif nums[second]+nums[third]>target:
                    third-=1
                else:
                    ans.append([nums[first],nums[second],nums[third]])
                    while second<third and nums[second]==nums[second+1]:
                        second+=1
                    while second<third and nums[third]==nums[third-1]:
                        third-=1
                    second+=1
                    third-=1
        return ans
