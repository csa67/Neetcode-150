package DP.oned;

import java.util.Arrays;

class Solution {
    //Recursion, TC- O(2^n) SC-O(n)
    public int rob(int[] nums) {
        return getMaxMoney(0,nums.length,nums);
    }

    private int getMaxMoney(int i, int n, int[] nums){
        if(i>=n){
            return 0;
        }

        int rob = nums[i] + getMaxMoney(i+2,n,nums);
        int norob = getMaxMoney(i+1,n,nums);

        return Math.max(rob,norob);

    }

    //Memoization, TC- O(n^2) SC-O(n)
    public int robMemo(int[] nums) {
        int n=nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo,-1);
        return getMaxMoneyMemo(0,n,nums,memo);
    }

    private int getMaxMoneyMemo(int i, int n, int[] nums,int[] memo){
        if(i>=n){
            return 0;
        }
        
        if(memo[i] != -1) return memo[i];
        int rob = nums[i] + getMaxMoneyMemo(i+2,n,nums,memo);
        int norob = getMaxMoneyMemo(i+1,n,nums,memo);

        return memo[i] = Math.max(rob,norob);

    }

    //Tabulation TC-O(n), SC-O(n) 
    //could bge space optimied further since every value is only dependent on next or second next value.
    public int rob2(int[] nums) {
        int n=nums.length;
        int[] dp = new int[n+1];
        
        dp[n] = 0;
        dp[n-1] = nums[n-1];
        
        for(int i=n-1;i>=0;i++){
            dp[i] = Math.max(nums[i]+dp[i+2],dp[i+1]);
        }

        return dp[0];

    }
}