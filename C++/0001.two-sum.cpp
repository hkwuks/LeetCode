//一遍哈希表，时间复杂度N
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> map;
        vector<int> v(2);
        for (int i = 0;i < nums.size();++i) {
            int complement = target - nums[i];
            if (map.count(complement)) {
                v[0] = map[complement];
                v[1] = i;
                break;
            }
            map[nums[i]] = i;
        }
        return v;
    }
};

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        if (nums.size() < 2)return {};
        map<int, int> m;
        for (int i = 0;i < nums.size();++i) {
            if (m.find(target - nums[i]) != m.end())
                return { m[target - nums[i]],i };
            m[nums[i]] = i;
        }
        return {};
    }
};