class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        // 这个方法不对
        if (rem < 0) {
            return -1;
        }
        // 上一步已经合成
        if (rem == 0) {
            return 0;
        }
        // 之前已经计算过，直接使用结果，避免重复计算
        if (count[rem - 1] != 0) {
            return count[rem - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            // res<0 说明无法合成；
            // res<min 保存了两种情况，1.前面返回-1，此路不通，回退，2.res得到一个路线，正常返回
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }
}

class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp=new int[amount+1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            for (int j = 0; j < coins.length; ++j) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}