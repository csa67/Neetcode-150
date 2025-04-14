package DP.oned;

class Solution {
    /*
     * Since we need longest possibility, check from ends, and then keep on shrinking the window.
     * Try from max length possible to 1.
     * 
     * TC - O(n^3) SC-O(1)
     */
    public String bruteforce(String s){
        int n=s.length();

        for(int length = n; length >= 1; length--){
            for(int start=0; start<=n-length;start++){
                if(isPalindrome(s,start,start+length)){
                    return s.substring(start, start+length);
                }
            }
        }

        return "";
    }

    public boolean isPalindrome(String s, int start, int end ){
        while(start <= end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
    /*
     * Using a similar logic, we tabulate the search space
     * we start from 1 length substrings and go on to use their results to check upto n length substrings.
     * 
     * TC-O(n^2) SC-O(n^2)
     */
    public String dp(String s){
        int n=s.length();
        boolean[][] dp = new boolean[n+1][n+1];
        int[] ans = new int[] { 0, 0 };

        //Every character of length 1 is a palindrome.
        for(int i=0; i<n;i++){
            dp[i][i] = true;
        }

        for(int i=0; i<n-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                ans[0] = i;
                ans[1] = i+1;
            }
        }

        for(int diff=2; diff<n;diff++){
            for(int start=0; start<n-diff;start++){
                int end = start+diff;
                if(s.charAt(start) == s.charAt(end) && dp[start+1][end-1]){
                    dp[start][end] = true;
                    ans[0] = start;
                    ans[1] = end;
                }
            }
        }

        return s.substring(ans[0], ans[1]);
    }

        /*
         * We can either have odd length/even length palindromes.
         * For odd length we have a single character which is a palindrome of itself, but for even every chaarcter has a mirror character.
         * 
         * TC- O(n^2) , n centers and expand which can cost up to O(n)
         * SC_O(1)
         */
        public String getLPSExpandAroundCenter(String s){
            if(s==null || s.length() < 1) return "";
            int n=s.length();

            int start = 0, end = 0;

            for(int i=0; i<n;i++){
                int oddLength = expand(i,i,s);
                int evenLength = expand(i,i+1,s);
                int len = Math.max(oddLength,evenLength);

                if(len > end-start){
                    start = i-(len-1)/2;
                    end = i+len/2;
                }
            }

            return s.substring(start, end);
        }

        private int expand(int i, int j, String s){

            while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)){
                i--;
                j++;
            }

            return j-i-1;
        }
    
    
    






     
}
