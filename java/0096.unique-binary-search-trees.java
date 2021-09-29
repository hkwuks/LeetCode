class Solution {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    public int numTrees(int n) {
        if (n <= 1) {
            return 1;
        }
        int result = 0;
        for (int i = 1; i <= n; ++i) {
            Integer left = map.get(i - 1);
            if (left == null) {
                left = numTrees(i - 1);
                map.put(i - 1, left);
            }
            Integer right = map.get(n - i);
            if (right == null) {
                right = numTrees(n - i);
                map.put(n - i, right);
            }
            result += left * right;
        }
        return result;
    }
}