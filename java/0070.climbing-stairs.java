// 递归
class Solution {
    public int climbStairs(int n) {
        int mem[] = new int[n + 1];
        return mem(n, mem);
    }

    public int mem(int n, int mem[]) {
        if (mem[n] > 0) {
            return mem[n];
        }
        if (n == 2) {
            mem[n] = 2;
        } else if (n == 1) {
            mem[n] = 1;
        } else {
            mem[n] = climbStairs(n - 1) + climbStairs(n - 2);
        }
        return mem[n];
    }
}

// 动态规划
class Solution {
    public int climbStairs(int n){
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

// 记忆动态规划
class Solution {
    public int climbStairs(int n) {
        if (n == 1) {return 1;}
        int p=1,q=2;
        for (int i = 3; i <= n; ++i) {
            int tmp = p + q;
            p = q;
            q = tmp;
        }
        return q;
    }
}