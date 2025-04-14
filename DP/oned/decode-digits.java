package DP.oned;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numDecodings(String s) {
        /*
         * Approach 1: recursion with memoization.
         * TC - O(n), SC- O(n)
         */
        Map<Integer, Integer> memo = new HashMap<>();
        return backtrack(0, s,memo);
    }

    private int backtrack(int i, String s,Map<Integer, Integer> memo) {
        int n = s.length();
        if (i == n) return 1; // reached the end → one valid way

        if (s.charAt(i) == '0') return 0; // can't decode a leading '0'

        if(memo.containsKey(i)) return memo.get(i);
        int ans = backtrack(i + 1, s,memo); // take one digit

        if (i + 1 < n) {
            int num = Integer.parseInt(s.substring(i, i + 2));
            if (num >= 10 && num <= 26) {
                ans += backtrack(i + 2, s,memo); // take two digits
            }
        }

        memo.put(i,ans);

        return ans;
    }

    /*
     * Approach 2: Tabulation
     */
    public int numDecodings2(String s){
        int[] dp = new int[s.length()+1];

        dp[0] = 1;

        dp[1] = s.charAt(0) == 0 ? 0 : 1;

        for(int i=2; i<=s.length();i++){

            if(s.charAt(i-1) != 0){
                dp[i] += dp[i-1];
            }

            int twoDigit = Integer.parseInt(s.substring(i-2, i));
            if(twoDigit >= 10 || twoDigit <= 26){
                dp[i] += dp[i-2];
            }
        }

        return dp[s.length()];
    }
}

