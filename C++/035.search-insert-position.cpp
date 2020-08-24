class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int i=0,j=nums.size()-1;
        if(target<nums[0]) return 0;
        if(target>nums[j]) return j+1;
        while(i<j){
            int m=(i+j)/2;
            if(target>nums[m]){
                i=m+1;
            }
            else if(target==nums[m]){
                return m;
            }
            else{
                j=m;
            }
        }
        return i;
    }
};