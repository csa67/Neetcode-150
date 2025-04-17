package DP.twod;

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[][] dp = new int[m + 1][n + 1];

        // Base cases: empty string comparisons
        for (int i = 0; i <= m; i++) dp[i][n] = m - i; 
        for (int j = 0; j <= n; j++) dp[m][j] = n - j; 

        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1]; 
                } else {
                    dp[i][j] = 1 + Math.min(
                        dp[i + 1][j],      // delete
                        Math.min(
                            dp[i][j + 1],  // insert
                            dp[i + 1][j + 1] // replace
                        )
                    );
                }
            }
        }

        return dp[0][0];
    }
}
