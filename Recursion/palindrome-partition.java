package Recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
 */
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        backtrack(0,s,curr,res);
        return res;
    }

    private void backtrack(int idx, String s, List<String> curr, List<List<String>> res){
        if(idx==s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=idx;i<s.length();i++){
            if(isPalindrome(s,idx,i)){
                curr.add(s.substring(idx,i+1)); 
                backtrack(i+1,s,curr,res);
                curr.remove(curr.size()-1);  
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end ){
        while(start <= end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}