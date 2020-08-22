class Solution {
public:
    int rob(vector<int>& nums) {
        if (nums.empty())
            return 0;
        int size = nums.size();
        if (size == 1)
            return nums[0];
        vector<int> dp = vector<int>(size, 0);
        dp[0] = nums[0];
        dp[1] = max(nums[0], nums[1]);
        for (int i = 2;i < size;++i) {
            dp[i] = max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[size - 1];
    }
};

//此方法节省了空间复杂度
class Solution {
public:
    int rob(vector<int>& nums) {
        if (nums.empty()) return 0;
        if (nums.size() == 1) return nums[0];
        int pre = 0, cur = 0, tmp;
        for (int num : nums) {
            tmp = cur;
            cur = max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }
};