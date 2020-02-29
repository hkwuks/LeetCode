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

//参照官方题解
class Solution{
private:
    int findIndex(vector<int>& nums,int target,bool left){
        int l=0,r=nums.size();
        while(l<r){
            int mid=(l+r)/2;
            if(nums[mid]>target||(left&&target==nums[mid]))
                r=mid;
            else
                l=mid+1;
        }
        return l;
    }
public:
vector<int> searchRange(vector<int>& nums, int target) {
    vector<int> a={-1,-1};
    int leftIdx=findIndex(nums,target,true);
    if(leftIdx==nums.size()||nums[leftIdx]!=target)
        return a;
    a[0]=leftIdx;
    a[1]=findIndex(nums,target,false)-1;
    return a;
    }
};