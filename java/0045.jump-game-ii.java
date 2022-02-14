class Solution {
    public int jump(int[] nums) {
        int end = 0;
        int max_P = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max_P = Math.max(max_P, i + nums[i]);
            if (i == end) {
                end = max_P;
                steps++;
            }
        }
        return steps;
    }
}