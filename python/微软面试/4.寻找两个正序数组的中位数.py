class Solution:

    def findMedianSortedArrays(self, nums1: List[int],
                               nums2: List[int]) -> float:
        l1, l2 = len(nums1), len(nums2)
        md = (l1 + l2) // 2
        if (l1 + l2) % 2 == 0:
            median = (self.find(nums1, nums2, md - 1) +
                      self.find(nums1, nums2, md)) / 2
            return median
        else:
            median = self.find(nums1, nums2, md)
            return median

    def find(self, nums1: List[int], nums2: List[int], k):
        k += 1
        l1, l2 = len(nums1), len(nums2)
        i, j = 0, 0
        while True:
            if i == l1:
                return nums2[j + k - 1]
            if j == l2:
                return nums1[i + k - 1]
            if k == 1:
                return min(nums1[i], nums2[j])

            half = k // 2
            if half == 0:
                half = 1
            new_i = min(i + half, l1) - 1
            new_j = min(j + half, l2) - 1
            if nums1[new_i] <= nums2[new_j]:
                k -= new_i - i + 1
                i = new_i + 1
            else:
                k -= new_j - j + 1
                j = new_j + 1
