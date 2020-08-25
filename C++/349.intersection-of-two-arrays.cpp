class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        unordered_set<int> set1;
        unordered_set<int> set2;
        vector<int> ans;
        for (int num : nums1) {
            set1.emplace(num);
        }
        for (int num : nums2) {
            set2.emplace(num);
        }
        if (set1.size() < set2.size()) {
            for (int num : set1)
                if (set2.count(num) == 1)
                    ans.emplace_back(num);
        }
        else {
            for (int num : set2)
                if (set1.count(num) == 1)
                    ans.emplace_back(num);
        }
        return ans;
    }
};