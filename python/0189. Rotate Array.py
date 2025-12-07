class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        k %= n
        nums.reverse()
        for i in range(k//2):
            nums[i],nums[k-1-i]=nums[k-1-i],nums[i]
        for i in range((n-k)//2):
            nums[k+i],nums[n-i-1]=nums[n-i-1],nums[k+i]

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        k %=len(nums)
        nums[:] = nums[-k:]+nums[:-k]
