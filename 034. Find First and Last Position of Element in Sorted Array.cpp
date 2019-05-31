class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int l=0,r=nums.size()-1;
        vector<int> a(2);
        a[0]=-1;
        a[1]=-1;
        while(l<=r&&nums[l]!=target&&nums[r]!=target){
            int mid=(l+r)/2;
            if(nums[mid]<target)
                l=mid+1;
            else if(nums[mid]>target)
                r=mid-1;
            else break;
        }
        if(l>r)return a;
        while(nums[l++]!=target);
        a[0]=l-1;
        while(nums[r--]!=target);
        a[1]=r+1;
        return a;
    }     
};

