class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int k=0;
        for(int i=0;i<nums.size();++i)
            if(nums[i]) nums[k++]=nums[i];
        while(k<nums.size())
            nums[k++]=0;
    }
};