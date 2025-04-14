package DP.oned;

class Solution{
    //DP approach to count the no:of substrings, TC-O(n^2) SC-O(n^2)
        public int countSubstrings(String s) {
            int n=s.length();
            int res=0;
            boolean[][] dp = new boolean[n][n];
    
            for(int i=0; i<n;i++){
                dp[i][i] = true;
                res+=1;
            }
    
            for(int i=0; i<n-1;i++){
                if(s.charAt(i) == s.charAt(i+1)){
                    dp[i][i+1]=true;
                    res+=1;
                }
            }
    
    
            for(int diff=2; diff<n;diff++){
                for(int start=0; start<n-diff;start++){
                    int end=start+diff;
                    if(s.charAt(start) == s.charAt(end)
                    && dp[start+1][end-1] 
                    ){
                        dp[start][end] = true;
                        res+=1;
                    }
                }
            }
    
            return res;
    
        }

    //approach 2: expand around centers
    //TC-O(n^2), SC-O(1)
    public int countSubstrings2(String s){
        int ans=0;

        for(int i=0; i<s.length();i++){
            ans+= expand(s,i,i);
            ans+=expand(s,i,i+1);
        }
        return ans;
    }

    private int expand(String s, int i, int j){
        int ans=0;
        while(i>=0 && j<s.length() &&s.charAt(i) ==s.charAt(j)){
            i--;
            j++;
            ans++;
        }

        return ans;
    }
}
