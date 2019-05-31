class Solution {
public:
    int search(vector<int>& nums, int target) {
        int l = 0, r = nums.size() - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if ((target<nums[0]^target>nums[mid]^nums[0]>nums[mid]))
                l = mid + 1;
            else
                r = mid;
        }
        return l == r && nums[l] == target ? l : -1;
    }
};
