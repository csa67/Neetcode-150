package DP.twod;

import java.util.Arrays;

class Solution {
    int n;
    int m;
    public int distinctSubsequences(String s, String t){
        n = s.length();
        m = t.length();
        if(n == 0||m==0) return 0;
        int[][] memo = new int[n][m];

        for(int[] row:memo) Arrays.fill(row,-1);
        return distinctSubsequences(0,0,s, t,memo);
    }

    private int distinctSubsequences(int i, int j, String s, String t, int[][] memo){
        if(j==t.length()){
            return 1;
        }
        if (i == s.length()) return 0; 

        if(memo[i][j] != -1) return memo[i][j];
        int count = 0;

            if(s.charAt(i) == t.charAt(j)){
                count+=distinctSubsequences(i+1,j+1,s,t,memo);
            }
        
            count+=distinctSubsequences(i+1, j, s, t,memo);

        return memo[i][j] = count;
    }

    //TC- O(m*n) SC-O(m*n)


    public int distinctSubsequences2(String s, String t){
        n = s.length();
        m = t.length();
        if(n == 0||m==0) return 0;
        
        int[] ahead = new int[m+1];
        ahead[m] = 1;
        
        for(int i=n-1; i>=0;i--){
            int[] curr = new int[m];
            for(int j=m-1;j>=0;j--){
                if(s.charAt(i) == t.charAt(j)){
                    curr[j]=ahead[j+1];
                }
            
                curr[j]=ahead[j];
            }
            ahead = curr;
        }
            

        return ahead[0];
    }
}
