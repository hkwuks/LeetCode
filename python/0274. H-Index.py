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
