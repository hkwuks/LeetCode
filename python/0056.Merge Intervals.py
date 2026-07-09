class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        newin = sorted(intervals, key = lambda x: x[0])
        merged = []
        left, right = newin[0][0], newin[0][1]
        merged.append([left, right])
        for item in newin:
            if right >= item[1]:
                continue
            elif right >= item[0] and right < item[1]:
                right = item[1]
                merged[-1][1] = right
            elif right < item[0]:
                left = item[0]
                right = item[1]
                merged.append([left, right])
        return merged
