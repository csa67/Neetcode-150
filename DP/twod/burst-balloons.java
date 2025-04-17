package DP.twod;

class Solution {
    int n;
    public int maxCoins(int[] nums) {
        n=nums.length;
        int[] extendedNums = new int[n+2];
        extendedNums[0] = 1;
        extendedNums[n + 1] = 1;

        System.arraycopy(nums,0,extendedNums,1,n);

        return getCoins(1,n,extendedNums);
        
    }

    private int getCoins(int l, int r, int[] nums){
        if(l>r) return 0;

        int maxcoins = Integer.MIN_VALUE;        
        for(int i=l; i<=r;i++){
            int coins = (nums[l-1]*nums[i]*nums[r+1]) + getCoins(l,i-1,nums)+getCoins(i+1,r,nums);
            maxcoins = Math.max(coins,maxcoins);
        }

        return maxcoins;
    }

    public int maxCoins2(int[] nums) {
        int n = nums.length;
        int[] extendedNums = new int[n + 2];
        extendedNums[0] = 1;
        extendedNums[n + 1] = 1;
        System.arraycopy(nums, 0, extendedNums, 1, n);

        int[][] dp = new int[n + 2][n + 2];

        for (int length = 1; length <= n; length++) {
            for (int i = 1; i <= n - length + 1; i++) {
                int j = i + length - 1;
                for (int k = i; k <= j; k++) {
                    int coins = extendedNums[i - 1] * extendedNums[k] * extendedNums[j + 1]
                                + dp[i][k - 1] + dp[k + 1][j];
                    dp[i][j] = Math.max(dp[i][j], coins);
                }
            }
        }

        return dp[1][n];
    }
}
