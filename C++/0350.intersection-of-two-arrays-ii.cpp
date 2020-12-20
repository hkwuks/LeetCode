class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        if (nums1.size() > nums2.size())
            return intersect(nums2, nums1);

        unordered_map<int, int> map;
        vector<int> ans;
        for (const int& num : nums1) {
            ++map[num];
        }
        for (const int& num : nums2) {
            if (map[num] > 0) {
                --map[num];
                ans.emplace_back(num);
            }
        }
        return ans;
    }
};