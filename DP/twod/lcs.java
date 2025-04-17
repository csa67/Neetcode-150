package DP.twod;

import java.util.Arrays;

class Solution {
    public int lcs(String s1, String s2){
        int n=s1.length();
        int m=s2.length();

        int[] dp = new int[m+1];

        for(int i=1; i<=n;i++){
            int prev = 0;
            for(int j=1;j<=m;j++){
                int temp=dp[j];
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[j] = 1+prev;
                }else{
                    dp[j] =Math.max(dp[j],prev);
                }
                prev = temp;
            } 
        }

        return dp[n];
    }
}
