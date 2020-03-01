class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        if(nums.size()<2)return {};
        map<int,int> m;
        for(int i=0;i<nums.size();++i){
            if(m.find(target-nums[i])!=m.end())
                return {m[target-nums[i]],i};
            m[nums[i]]=i;
        }
        return {};
    }
};