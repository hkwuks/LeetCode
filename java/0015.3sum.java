class Solution {
    public List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length - 2; ++i){
            if(nums[i] > 0) break; // 如果第一个数大于0，那就肯定没有解
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int L = i + 1,R = nums.length-1;
            int target = -nums[i];
            while(L < R){
                int sum = nums[L] + nums[R];
                if(sum == target){
                    while(L < R && nums[L] == nums[L+1]) ++L;
                    while(L < R && nums[R] == nums[R-1]) --R;
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    result.add(list);
                    ++L;
                    --R;
                }
                else if(sum < target) ++L;
                else --R;
            }
        }
        return result;
    }
}