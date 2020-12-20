class Solution {
public:
    int singleNonDuplicate(vector<int>& nums) {
        int i = 0, j = nums.size() - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (m % 2 == 1) --m;
            if (nums[m] == nums[m + 1]) {
                i = m + 2;
            }
            else {
                j = m;
            }
        }
        return nums[i];
    }
};