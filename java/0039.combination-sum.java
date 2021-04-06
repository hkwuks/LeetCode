class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(candidates, target, res, combine, 0);
        return res;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> combine, int i) {
        if (i == candidates.length) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(combine));
            return;
        }
        // 遍历candidates中所有的元素
        dfs(candidates, target, res, combine, i + 1);
        // 当前数符合条件
        if (target - candidates[i] >= 0) {
            combine.add(candidates[i]);
            dfs(candidates, target-candidates[i], res, combine, i);
            combine.remove(combine.size() - 1);
        }
    }
}