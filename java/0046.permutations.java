class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutes = new ArrayList<>();
        
        List<Integer> permute = new ArrayList<>();
        for (int num : nums) {
            permute.add(num);
        }
        int len = nums.length;
        backtrack(permutes, permute, len, 0);
        return permutes;
    }

    public void backtrack(List<List<Integer>> permutes, List<Integer> permute, int len, int first) {
        // 所有的数都填完了
        if (first == len) {
            permutes.add(new ArrayList<Integer>(permute));
        }
        for (int i = first; i < len; ++i) {
            Collections.swap(permute, first, i);
            backtrack(permutes, permute, len, first + 1);
            // 保证交换前的顺序不变
            Collections.swap(permute, first, i);
        }
    }
}