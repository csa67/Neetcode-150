package DP.twod;

class Solution {
    int n;
    int m;
    public boolean isMatch(String s, String p) {
        n = s.length();
        m = p.length();

        return match(0,0,s,p);
    }

    private boolean match(int i, int j, String s, String p){
        if(i==n && j==m) return true;

        if(j==m) return false;

        if(i==n){
            for(int k=j;k<m;k++){
                if(p.charAt(j) != '*') return false;
            }

            return true;
        }

        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.' ){
            return match(i+1,j+1,s,p);
        }
        
        if(p.charAt(j) == '*'){
            return match(i+1,j,s,p) || match(i,j+1,s,p);
        }
    

        return false;

    }

    
        public boolean isMatch2(String text, String pattern) {
            boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
            dp[text.length()][pattern.length()] = true;
    
            for (int i = text.length(); i >= 0; i--) {
                for (int j = pattern.length() - 1; j >= 0; j--) {
                    boolean first_match =
                        (i < text.length() &&
                            (pattern.charAt(j) == text.charAt(i) ||
                                pattern.charAt(j) == '.'));
                    if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                        dp[i][j] = dp[i][j + 2] || (first_match && dp[i + 1][j]);
                    } else {
                        dp[i][j] = first_match && dp[i + 1][j + 1];
                    }
                }
            }
            return dp[0][0];
        }

}