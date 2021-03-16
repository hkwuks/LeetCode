// 求得左右局部最高点，然后求得局部最高点的重合部分即可
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int ans = 0;
        int len = height.length;
        int[] left_max=new int[len];
        int[] right_max=new int[len];
        left_max[0] = height[0];
        for (int i = 1; i < len; ++i) {
            left_max[i] = Math.max(left_max[i - 1], height[i]);
        }
        right_max[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; --i) {
            right_max[i] = Math.max(right_max[i + 1], height[i]);
        }
        for (int i = 0; i < len; ++i) {
            ans += Math.min(right_max[i], left_max[i])-height[i];
        }
        return ans;
    }
}