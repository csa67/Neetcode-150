package DP.oned;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    //Approach 1: Recursion+memo
    //TC - O(n^2), SC-O(n)
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>();

        for(String word:wordDict){
            wordSet.add(word);
        }

        int n=s.length();
        Boolean[] memo = new Boolean[n];
        return backtrack(0,s,wordSet,memo);
    }

    private boolean backtrack(int l, String s, Set<String> wordSet, Boolean[] memo){
        if (l == s.length()) return true;
        
        if(memo[l] != null) return memo[l];
        if(wordSet.contains(s.substring(l))) return true;

        for(int i=l;i<s.length();i++){
            if(wordSet.contains(s.substring(l,i+1)) && backtrack(i+1,s,wordSet,memo)){
                memo[l] = true;
                return true;
            }
        }

        memo[l] =  false;
        return false;
    }

    /*Aprroach 2: Check with substrings,
     * Iterate through the string and check if the substring matches any word in the wordset.
     * Optimal when words are less in the word dict.
     * 
     * TC - O(n.m.k), SC-O(n)
     */
        public boolean wordBreak2(String s, List<String> wordDict) {
            Set<String> wordSet = new HashSet<>(wordDict);
            int n = s.length();
            boolean[] dp = new boolean[n + 1];
            dp[0] = true; // base case: empty string is always breakable
    
            for (int i = 1; i <= n; i++) {
                for (String word : wordSet) {
                    int len = word.length();
                    if (i >= len && dp[i - len]) {
                        // Check if the last len characters match the word
                        if (s.substring(i - len, i).equals(word)) {
                            dp[i] = true;
                            break;
                        }
                    }
                }
            }
    
            return dp[n];
        }
    
}
