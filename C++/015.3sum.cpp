//循环+双指针，时间复杂度N*N
class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> ans;
        int len = nums.size();
        if (len < 3) return ans;
        sort(nums.begin(), nums.end());
        for (int first = 0;first < nums.size();++first) {
            if (nums[first] > 0) break;
            if (first > 0 && nums[first - 1] == nums[first])//在前面的first已经使用相同的元素查找了所有的可能性，所以在遇到与前面first相同元素时，可以跳过
                continue;
            int target = -nums[first];
            int third = nums.size() - 1;
            for (int second = first + 1;second < nums.size();++second) {
                int sum = nums[second] + nums[third];
                if (second > first + 1 && nums[second - 1] == nums[second])//在前面的second已经使用相同的元素查找了所有的可能性，所以在遇到与前面second相同元素时，可以跳过
                    continue;
                while (second < third && sum > target)//在遇到符合条件的third后立刻停止向前移动，随即进入下一个循环，second+1，避免了重复
                    --third;
                if (second < third && sum == target)
                    ans.push_back({ nums[first], nums[second], nums[third] });

                if (second == third) break;
            }
        }
        return ans;
    }
};

//另一种写法，时间复杂度N*N
class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> re;
        int len = nums.size();
        if (len < 3)return re;
        sort(nums.begin(), nums.end());
        for (int i = 0;i < len - 2;++i) {
            if (nums[i] > 0) break;//如果第一个数大于0，肯定没有解
            if (i > 0 && nums[i] == nums[i - 1]) continue;//去除重复
            int t = -nums[i];
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[L] + nums[R];
                if (sum == t) {
                    re.push_back({ nums[i],nums[L],nums[R] });
                    while (L < R && nums[L] == nums[L + 1]) ++L;
                    while (L < R && nums[R] == nums[R - 1]) --R;
                    ++L;
                    --R;
                }
                else if (sum < t) ++L;
                else --R;
            }
        }
        return re;
    }
};