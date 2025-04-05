/*
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 */

 /*
  * Constraints: what if a string is empty? return false.
  * case sensitive? yes.
  */

import java.util.HashMap;
import java.util.Map;

class Solution{
  public boolean checkValidAnagrams(String s, String t){
    /*
     * if a string has anagrams, they'd be of the same length. so I can first check if they are of the same length.
     * since case-sensitive, first convert both strings to be of same case.
     * 
     * Bruteforce: Sort and compare both strings.
     * 
     * This is better. and broad and generic. If unicode characters are also present, this is the solution.
     * 
     * Optimal, instead of a hashmap use a char array of 26 characters, if only alphabets.
     */

     s = s.toLowerCase();
     t = t.toLowerCase();

     Map<Character,Integer> characterFreqMap = new HashMap<>(s.length());

     for(char ch:s.toCharArray()){
        characterFreqMap.put(ch,characterFreqMap.getOrDefault(ch, 0)+1);
     }

     for(char ch:t.toCharArray()){
        if(characterFreqMap.containsKey(ch)){
            int currentCount = characterFreqMap.get(ch);
            if(currentCount>1) characterFreqMap.put(ch,currentCount-1);
            else characterFreqMap.remove(ch);
        }else{
            return false;
        }
     }

     return characterFreqMap.size() >= 1 ? false : true;
  }
}