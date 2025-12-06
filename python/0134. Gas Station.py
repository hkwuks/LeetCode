class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        n = len(gas)
        sum_ = 0
        minS = sys.maxsize
        minI = 0

        for i in range(n):
            sum_ +=gas[i] - cost[i]
            if sum_ < minS:
                minI=i
                minS = sum_
        
        return -1 if sum_<0 else (minI+1)%n

  class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        n = len(gas)
        i = 0

        while i<n:
            sum_g=sum_c=0
            cnt=0
            while cnt < n:
                j = (i + cnt) % n
                sum_g+=gas[j]
                sum_c+=cost[j]
                if sum_g<sum_c:
                    break
                cnt +=1

            if cnt==n:
                return i
            else:
                i+=cnt + 1
        
        return -1
