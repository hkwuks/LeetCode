class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        map=list()
        max_len=0
        for c in s:
            while map.__contains__(c):
                max_len = map.__len__() if map.__len__() > max_len else max_len
                map.__delitem__(0)
            else:
                map.append(c)
        max_len = map.__len__() if map.__len__() > max_len else max_len
        return max_len
