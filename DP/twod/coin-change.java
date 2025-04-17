package DP.twod;

import java.util.Arrays;

class Solution {
    public int getPossibleWays(int amount, int[] coins){
        int[][] memo = new int[coins.length][amount+1];

        for(int[] row:memo){
            Arrays.fill(row,-1);
        }
        return backtrack(0, amount, coins,memo);
    }

    private int backtrack(int i, int amount, int[] coins, int[][] memo){
        if(amount == 0){
            return 1;
        }
        
        if(i==coins.length){
            return 0;
        }

        if(memo[i][amount] != -1) return memo[i][amount];

        int ways = 0;

        if(amount >= coins[i]){
            ways += backtrack(i, amount-coins[i], coins,memo);
        }
        ways+=backtrack(i+1, amount, coins,memo);

        return memo[i][amount] = ways;
    }

    //TC- O(mn) SC-O(mn)
    public int getPossibleWaysTabulate(int amount, int[] coins){
        int n = coins.length;
        int[][] dp = new int[coins.length][amount+1];

        for(int i=0; i<n;i++){
            dp[i][0] = 1;
        } 

        for(int i=1;i<=n;i--){
            for(int j=0; j<=amount;j++){
                
                if(j>coins[i-1]){
                    
                 dp[i][j] += dp[i][j-coins[i-1]];
                }

                dp[i][j] += dp[i-1][j];
            }
        }

        return dp[n][amount];
    }
}
