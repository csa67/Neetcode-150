package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

/*
 * Given a string s, find the length of the longest substring without duplicate characters.
 * 
 * Input - string, case senstive - yes. output length, integer.
 */
class Solution {
    public int longestSubstringWithoutDuplicates(String s){

        int n=s.length();
        if(n <= 1) return n;


       Set<Character> windowSet = new HashSet<>();
       int maxsize = 0;
        int l=0;
        for(int r=0;l<=r && r<n;r++){
            while(windowSet.contains(s.charAt(r))){
                windowSet.remove(s.charAt(l++));
            }
            windowSet.add(s.charAt(r));
            maxsize = Math.max(maxsize,r-l+1);
        }
       
        return maxsize;
    }
}
