package DP.oned;

import java.util.Arrays;

class Solution {
    //Recursive. TC-O(2^n) SC-O(n)
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        return Math.min(
            backtrack(0,n,cost),
            backtrack(1,n,cost)
        );
    }

    private int backtrack(int i, int n, int[] cost){
        if(i==n){
            return 0;
        }

        if(i>n) return Integer.MAX_VALUE;

        return cost[i] + Math.min(
            backtrack(i+1,n,cost),
            backtrack(i+2,n,cost)
        );
    }

    //Memoization TC-O(n) SC-O(n)
    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int[] memo = new int[n+1];
        Arrays.fill(memo,-1);
        return Math.min(
            backtrackMemo(0,n,cost,memo),
            backtrackMemo(1,n,cost,memo)
        );
    }

    private int backtrackMemo(int i, int n, int[] cost, int[] memo){
        if(i==n){
            return 0;
        }

        if(i>n) return Integer.MAX_VALUE;

        if(memo[i] != -1) return memo[i];

        return memo[i] = cost[i] + Math.min(
            backtrackMemo(i+1,n,cost,memo),
            backtrackMemo(i+2,n,cost,memo)
        );
    }

    //Tabulation TC-O(n) SC-O(n)
    public int minCostClimbingStairs3(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        
        dp[n] = 0;
        dp[n-1] = cost[n-1];

        for(int i=n-2;i>=0;i--){
            dp[i] = cost[i] + Math.min(dp[i+1],dp[i+2]);
        }

        return Math.min(dp[0],dp[1]);
    }

    //Tabulation-space optimization TC-O(n) SC-O(1)
    public int minCostClimbingStairs4(int[] cost) {
        int n = cost.length;
        
        int next2 = 0;
        int next1 = cost[n-1];

        for(int i=n-2;i>=0;i--){
            int curr = cost[i] + Math.min(next1,next2);
            next2 = next1;
            next1 = curr;
        }

        return Math.min(next1, next2);
    }
}