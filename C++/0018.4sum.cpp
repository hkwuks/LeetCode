class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        vector<vector<int>> re;
        int len = nums.size();
        if (len < 4) return re;
        sort(nums.begin(), nums.end());
        for (int i = 0;i < len - 3;++i) {
            if (nums[i] > target / 4) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1;j < len - 2;++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int t = target - nums[i] - nums[j];
                int L = j + 1;
                int R = len - 1;
                while (L < R) {
                    int sum = nums[L] + nums[R];
                    if (sum == t) {
                        re.push_back({ nums[i],nums[j],nums[L],nums[R] });
                        while (L < R && nums[L] == nums[L + 1]) ++L;
                        while (L < R && nums[R] == nums[R - 1]) --R;
                        ++L;
                        --R;
                    }
                    else if (sum < t) ++L;
                    else --R;
                }
            }
        }
        return re;
    }
};