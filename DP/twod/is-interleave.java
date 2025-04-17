package DP.twod;

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        Boolean[][][] memo = new Boolean[s1.length() + 1][s2.length() + 1][s3.length() + 1];
        return check(0, 0, 0, s1, s2, s3, memo);
    }

    private boolean check(int i, int j, int k, String s1, String s2, String s3, Boolean[][][] memo) {
        if (k == s3.length()) {
            return i == s1.length() && j == s2.length();
        }

        if (memo[i][j][k] != null) return memo[i][j][k];

        boolean ans = false;

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            ans = ans || check(i + 1, j, k + 1, s1, s2, s3, memo);
        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            ans = ans || check(i, j + 1, k + 1, s1, s2, s3, memo);
        }

        return memo[i][j][k] = ans;
    }

    public boolean isInterleave2(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();

        if (n + m != t) return false;

        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        // First column: only characters from s1
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }

        // First row: only characters from s2
        for (int j = 1; j <= m; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        // Fill the rest of the table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                           (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }

        return dp[n][m];
    }
}
