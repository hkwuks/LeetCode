class Solution {
public:
    int findLengthOfLCIS(vector<int>& nums) {
        if (nums.empty()) return 0;
        int cur = 1, ans = 1;
        for (int i = 1;i < nums.size();++i) {
            if (nums[i] > nums[i - 1]) {
                ++cur;
                ans = max(ans, cur);
            }
            else {
                cur = 1;
            }
        }
        return ans;
    }
};

class Solution {
public:
    int findLengthOfLCIS(vector<int>& nums) {
        int ans = 0, anchor = 0;
        for (int i = 0;i < nums.size();++i) {
            if (i > 0 && nums[i] <= nums[i - 1]) anchor = i;
            ans = max(ans, i - anchor + 1);
        }
        return ans;
    }
};