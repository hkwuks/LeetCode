class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        mid_count = len(nums)//2
        while True:
            cand = random.choice(nums)
            if sum(1 for e in nums if e==cand) > mid_count:
                return cand

class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        nums.sort()
        return nums[len(nums)//2]

class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        counts = collections.Counter(nums)
        return max(counts.keys(), key=counts.get)

class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        count = 0
        cand = None

        for n in nums:
            if count == 0:
                cand = n
            count +=(1 if n==cand else -1)

        return cand
