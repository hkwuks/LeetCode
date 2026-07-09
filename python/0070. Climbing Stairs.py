class Solution:
    def climbStairs(self, n: int) -> int:
        steps = [1] + [2] + [0] * (n - 2)
        for i in range(0, n):
            if i > 1:
                steps[i] = steps[i - 1] + steps[i - 2]
        return steps[n - 1]
