class Solution {
public:
    int rob(vector<int>& nums) {
        if (nums.empty()) return 0;
        if (nums.size() == 1) return nums[0];
        return max(myrob(nums, 0, nums.size() - 1), myrob(nums, 1, nums.size()));
    }
    int myrob(vector<int>& nums, int i, int j) {
        int pre = 0, cur = 0, tmp;
        for (int k = i;k < j;++k) {
            tmp = cur;
            cur = max(pre + nums[k], cur);
            pre = tmp;
        }
        return cur;
    }
};