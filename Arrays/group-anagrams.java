//Given an array of strings strs, group the anagrams together. You can return the answer in any order.

 /*
  * constraints - all are in lowercase.
  */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution{
    /**
     * Bruteforce - Sort each word, check hashmap and add it to hashmap.
     * 
     * Sets may not work because freq of each letter would also matter. Adding a hash between each character would enable to demarcate counts of each character.
     * Eg:  a and b have counts 11 and 1 respectively, but when combined - 111. so it could also return true for a-1 and b-11.
     */
    public List<List<String>> groupAnagrams(List<String> words){

        Map<String,ArrayList<String>> anagramMap = new HashMap<>();
        int[] counts = new int[26];

        for(String word: words){
            Arrays.fill(counts,0);

            for(char ch: word.toCharArray()){
                counts[ch-'a']++;
            }

            StringBuilder charAnagram = new StringBuilder();
            for(int i=0; i<26;i++){
                charAnagram.append('#');
                charAnagram.append(counts[i]);
            }

            String str = charAnagram.toString();
            if(!anagramMap.containsKey(str)){
                anagramMap.put(str,new ArrayList<>());
            }
            anagramMap.get(str).add(word);
        }

        return new ArrayList(anagramMap.values());
    }
  }

  /*
   * TC - O(NK) SC-O(NK)
   */