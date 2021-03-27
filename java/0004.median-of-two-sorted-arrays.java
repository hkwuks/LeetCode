class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int md=(n+m)/2;
        if((n+m)%2==0){
            double median = (find(nums1, nums2, md - 1) + find(nums1, nums2, md)) / 2.0;
            return median;
        }else {
            double median = find(nums1, nums2, md);
            return median;
        }
    }
    
    public int find(int[] nums1, int[] nums2, int k) {
        int i = 0, j = 0;
        int tmp;
        while (true) {
            if (i >= nums1.length) {
                return nums2[k - i];
            }
            if (j >= nums2.length) {
                return nums1[k - j];
            }
            if (nums1[i] < nums2[j]) {
                tmp = nums1[i];
                ++i;
            } else {
                tmp = nums2[j];
                ++j;
            }
            if (i + j == k + 1) {
                return tmp;
            }
        }
    }
    
    public int find2(int[] nums1, int[] nums2, int k) {
        k+=1;
        int len1 = nums1.length, len2 = nums2.length;
        int i = 0, j = 0;
        while (true) {
            if (i == len1) {
                return nums2[j + k - 1];
            }
            if (j == len2) {
                return nums1[i + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[i], nums2[j]);
            }
            int half = k / 2;
            if (half == 0) {
                half = 1;
            }
            int newI = Math.min(i + half, len1) - 1;
            int newJ = Math.min(j + half, len2) - 1;
            if (nums1[newI] <= nums2[newJ]) {
                k -= newI - i + 1;
                i = newI + 1;
            } else {
                k -= newJ - j + 1;
                j = newJ + 1;
            }
        }
    }
}