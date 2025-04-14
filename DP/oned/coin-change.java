package DP.oned;

import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -1);
        int res = backtrack(coins, amount, memo);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int backtrack(int[] coins, int amount, int[] memo) {
        if (amount == 0) return 0;
        if (amount < 0) return Integer.MAX_VALUE;
        if (memo[amount] != -1) return memo[amount];

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = backtrack(coins, amount - coin, memo);
            if (res != Integer.MAX_VALUE) {
                min = Math.min(min, res + 1);
            }
        }

        memo[amount] = min;
        return min;
    }
}

