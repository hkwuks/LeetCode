//时间复杂度N*K，超时
class Solution {
public:
    bool containsNearbyAlmostDuplicate(vector<int>& nums, int k, int t) {
        for (int i = 0;i < nums.size();++i) {
            for (int j = max(i - k, 0);j < i;++j) {
                if (abs((long)nums[i] - nums[j]) <= t)
                    return true;
            }
        }
        return false;
    }
};

//桶排序的方法，时间复杂度N
class Solution {
public:
    bool containsNearbyAlmostDuplicate(vector<int>& nums, int k, int t) {
        long long mod = t + 1LL;
        unordered_map<long long, long long>buck;
        for (int i = 0;i < nums.size();++i) {
            long long nth = nums[i] / mod;
            if (nums[i] < 0) --nth;
            if (buck.count(nth))
                return true;
            else if (buck.count(nth - 1) && abs(nums[i] - buck[nth - 1]) <= t)
                return true;
            else if (buck.count(nth + 1) && abs(nums[i] - buck[nth + 1]) <= t)
                return true;
            buck[nth] = nums[i];
            if (i >= k) {
                buck.erase(nums[i - k] / mod);
            }
        }
        return false;
    }
};

//平衡二叉树，时间复杂度N*log(min(N,K)
class Solution {
public:
    bool containsNearbyAlmostDuplicate(vector<int>& nums, int k, int t) {
        set<long> set;
        for (int i = 0;i < nums.size();++i) {
            auto n = set.lower_bound((long)nums[i] - t);
            if (n != set.end() && n <= (long)nums[i] + t)
                return true;
            set.emplace(nums[i]);
            if (set.size() > k)
                set.erase(nums[i - k]);
        }
        return false;
    }
};