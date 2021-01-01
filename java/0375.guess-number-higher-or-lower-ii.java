class Solution {
    public int getMoneyAmount(int n) {
        return calculate(1, n);
    }

    public int calculate(int l, int r) {
        if (l >= r) {
            return 0;
        }
        int minres = Integer.MAX_VALUE;
        for (int i = (l + r) / 2; i <= r; ++i) {
            int res = i + Math.max(calculate(i + 1, r), calculate(l, i - 1));
            minres = Math.min(res, minres);
        }
        return minres;
    }
}

class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int len = 2; len <= n; ++len) {
            for (int start = 1; start <= n - len + 1; ++start) {
                int minres = Integer.MAX_VALUE;
                for (int piv = start+(len-1)/2; piv < start + len - 1; ++piv) {
                    int res = piv + Math.max(dp[start][piv - 1], dp[piv + 1][start + len - 1]);
                    minres=Math.min(res,minres);
                }
                dp[start][start+len-1]=minres;
            }
        }
        return dp[1][n];
    }
}