class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if len(citations)==0:
            return 0
        if len(citations)==1:
            return min(1,citations[0])

        i, j = 0, len(citations)
        return self.find(i,j,citations)

    def find(self,start, end, citations):
        if start > end:
            return -1

        mid = (start + end) // 2
        left = self.find(mid + 1, end, citations)
        if left != -1:
            return left
        if self.judge(citations, mid):
            return mid
        right = self.find(start, mid - 1, citations)
        if right != -1:
            return right
        return -1

    def judge(self,citations, h):
        if len(citations) < h:
            return False
        cnt = 0
        for i in range(len(citations)):
            if citations[i] >= h:
                cnt += 1

        if cnt < h:
            return False
        return True


class Solution:
    def hIndex(self, citations: List[int]) -> int:
        l,r=0,len(citations)
        while l<r:
            mid = (l+r+1)>>1
            cnt=0

            for v in citations:
                if v>=mid:
                    cnt+=1
            
            if cnt>=mid:
                l = mid
            else:
                r = mid-1
        
        return l

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        tot=0
        counter = [0] * (n+1)
        for c in citations:
            if c>=n:
                counter[n]+=1
            else:
                counter[c]+=1
        
        for i in range(n,-1,-1):
            tot+=counter[i]
            if tot>=i:
                return i
        return 0

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        sorted_c = sorted(citations,reverse=True)
        i=0
        h=0
        n=len(citations)
        while i<n and sorted_c[i]>h:
            h+=1
            i+=1
        return h
