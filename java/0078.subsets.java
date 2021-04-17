class Solution{
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        if (len == 0) {
            return ans;
        }
        dfs(0, nums,ans,tmp);
        return ans;
    }

    public void dfs(int cur,int[] nums, List<List<Integer>> ans,List<Integer> tmp) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        tmp.add(nums[cur]);
        dfs(cur+1, nums, ans, tmp);
        tmp.remove(tmp.size()-1);
        dfs(cur + 1, nums, ans, tmp);       
    }
}


class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        int len = nums.length;
        for (int mark = 0; mark < (1 << len); ++mark) {
            tmp.clear();
            for (int i = 0; i < len; ++i) {
                if ((mark & (1 << i)) != 0) {
                    tmp.add(nums[i]);
                }
            }
            ans.add(new ArrayList<Integer>(tmp));
        }
        return ans;
    }   
}