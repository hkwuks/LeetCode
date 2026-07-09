class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        count = dict()
        for i in range(0,len(s) - 10 + 1):
            tmp = s[i:i+10]
            if tmp in count:
                count[tmp] += 1
            else:
                count[tmp] = 1
        return [item for item in count if count[item] > 1]