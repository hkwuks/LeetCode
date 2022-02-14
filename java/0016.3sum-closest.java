class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];
        int L = 1, R = nums.length - 1;
        for (int i = 0; i < nums.length; ++i) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            while(L < R){
                int tmp = nums[i] + nums[L] + nums[R];
                if(Math.abs(tmp - target) < Math.abs(sum - target)){
                    sum = tmp;
                }
                if(tmp < target) ++L;
                else if(tmp > target) --R;
                else return target;
            }
        }
        return sum;
    }
}