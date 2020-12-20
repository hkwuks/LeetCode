class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0;i < nums.size() - 2;++i) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int L = i + 1, R = nums.size() - 1;
            while (L < R) {
                int tmp = nums[i] + nums[L] + nums[R];
                if (abs(tmp - target) < abs(ans - target))
                    ans = tmp;
                if (tmp < target) ++L;
                else if (tmp > target) --R;
                else return target;
            }
        }
        return ans;
    }
};